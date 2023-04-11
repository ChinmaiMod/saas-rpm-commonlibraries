package com.io.rpm.fcm;

import com.google.firebase.messaging.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class FCMService {

    private Logger logger = LoggerFactory.getLogger(FCMService.class);

    public void sendMessage(MessageDto request)
            throws InterruptedException, ExecutionException {
        Message message = getPreconfiguredMessageWithData(request);
        String response = sendAndGetResponse(message);
        logger.info("Sent message with data. Topic: " + request.getTopic() + ", " + response);
    }

    public void sendMessageWithoutData(MessageDto request)
            throws InterruptedException, ExecutionException {
        Message message = getPreconfiguredMessageWithoutData(request);
        String response = sendAndGetResponse(message);
        logger.info("Sent message without data. Topic: " + request.getTopic() + ", " + response);
    }

    public String sendMessageToToken(MessageDto request){
        try {
            Message message = getPreconfiguredMessageToToken(request);
            String response = sendAndGetResponse(message);
            logger.info("Sent message to token. Device token: " + request.getToken() + ", " + response);
            return response;
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    private String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
        return FirebaseMessaging.getInstance().sendAsync(message).get();
    }

    private AndroidConfig getAndroidConfig(String topic) {
        return AndroidConfig.builder()
                .setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey(topic)
                .setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(AndroidNotification.builder().setSound(NotificationParameter.SOUND.getValue())
                        .setColor(NotificationParameter.COLOR.getValue()).setTag(topic).build()).build();
    }

    private ApnsConfig getApnsConfig(String topic) {
        return ApnsConfig.builder()
                .setAps(Aps.builder().setCategory(topic).setThreadId(topic).build()).build();
    }

    private Message getPreconfiguredMessageToToken(MessageDto request) {
        return getPreconfiguredMessageBuilder(request).setToken(request.getToken())
                .build();
    }

    private Message getPreconfiguredMessageWithoutData(MessageDto request) {
        return getPreconfiguredMessageBuilder(request).setTopic(request.getTopic())
                .build();
    }

    private Message getPreconfiguredMessageWithData(MessageDto request) {
        return getPreconfiguredMessageBuilder(request).putAllData(request.getData()).setTopic(request.getTopic())
                .build();
    }

    private Message.Builder getPreconfiguredMessageBuilder(MessageDto request) {
        Notification notification = Notification
                .builder()
                .setTitle(request.getTitle())
                .setBody(request.getMessage())
                .build();
        AndroidConfig androidConfig = getAndroidConfig(request.getTopic());
        ApnsConfig apnsConfig = getApnsConfig(request.getTopic());
        WebpushConfig webConfig = getWebConfig(request);
        Map<String,String> data=new HashMap<>();
        data.put("senderId",String.valueOf(request.getSenderId()));
        data.put("receiverId",String.valueOf(request.getReceiverId()));
        data.put("serviceId",String.valueOf(request.getServiceId()));
        data.put("serviceName",request.getSenderName());
        data.put("recipientName",request.getRecipientName());
        return Message.builder()
                .setWebpushConfig(webConfig)
                .setApnsConfig(apnsConfig)
                .setAndroidConfig(androidConfig)
                .putAllData(data)
                .setNotification(notification);
    }

    private WebpushConfig getWebConfig(MessageDto msg) {
        return WebpushConfig.builder()
                .setNotification(
                        WebpushNotification.builder()
                                .setTitle(msg.getTitle())
                                .setBody(msg.getMessage())
                                .setIcon(msg.getImage())
                                .build()
                ).build();
    }

}