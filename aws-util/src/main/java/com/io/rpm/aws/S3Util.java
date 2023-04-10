package com.io.rpm.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.InputStream;

@Slf4j
@Component
public class S3Util {
    private final AmazonS3 s3client;

    public S3Util(AmazonS3 s3client) {
        this.s3client = s3client;
    }

    public Bucket bucket(@NonNull String bucketName) {
        Assert.notNull(bucketName, "bucketName must not be null");
        return new Bucket(bucketName);
    }

    public class Bucket {

        @NonNull
        private final String bucketName;

        private String domain;

        private String folder;

        private Bucket(@NonNull String bucketName) {
            this.bucketName = bucketName;
        }


        public Bucket folder(@NonNull String folder) {
            Assert.notNull(folder, "DomainName must not be null");
            this.folder = folder;
            return this;
        }

        public PutObjectResult put(@NonNull String key, @NonNull InputStream inputStream) {
            Assert.notNull(inputStream, "inputStream must not be null");
            return s3client.putObject(new PutObjectRequest(bucketName, getKey(key), inputStream, new ObjectMetadata()));
        }

        public PutObjectResult put(@NonNull String key, Long fileLength, @NonNull InputStream inputStream) {
            Assert.notNull(inputStream, "inputStream must not be null");
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(fileLength);
            return s3client.putObject(new PutObjectRequest(bucketName, getKey(key), inputStream, metadata));
        }

        public S3Object get(String key) {
            return s3client.getObject(new GetObjectRequest(bucketName, getKey(key)));
        }

        public void delete(@NonNull String key) {
            s3client.deleteObject(new DeleteObjectRequest(bucketName, getKey(key)));
        }

        public boolean isExist(String key) {
            return s3client.doesObjectExist(bucketName, getKey(key));
        }

        @Async
        public void move(String key, String targetBucket, String targetPath) {
            s3client.copyObject(new CopyObjectRequest(bucketName, key, targetBucket, targetPath + "/" + key));
        }

        @Async
        public void move(String key, String targetBucket, String targetPath, boolean sourceDelete) {
            s3client.copyObject(new CopyObjectRequest(bucketName, key, targetBucket, targetPath + "/" + key));
            if (sourceDelete)
                delete(key);
        }

        @Async
        public void move(String sourceKey,String destinationKey, String targetBucket, String targetPath, boolean sourceDelete) {
            s3client.copyObject(new CopyObjectRequest(bucketName, sourceKey, targetBucket, targetPath + "/" + destinationKey));
            if (sourceDelete)
                delete(sourceKey);
        }

        public String getUrl(@NonNull String filePath) {
            Assert.notNull(filePath, "filePath must not be null");
            return String.format("https://s3-%s.amazonaws.com/%s/%s", s3client.getRegionName(), bucketName, filePath);
        }

        private String getKey(String key) {
            Assert.notNull(key, "key must not be null");
            StringBuilder sb = new StringBuilder();
            if (domain != null)
                sb.append(domain).append("/");
            if (folder != null)
                sb.append(folder);
            sb.append(key);
            return sb.toString();
        }

    }

}