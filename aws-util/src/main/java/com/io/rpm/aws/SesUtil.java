package com.io.rpm.aws;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@Slf4j
@Component
@EnableAsync
public class SesUtil {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private final SesClient client;

    public SesUtil(SesClient client) {
        this.client = client;
    }

    public void sendMail(List<Email> list) {
        try {
            if (list != null && !list.isEmpty()) {
                for (Email email : list) {
                    sendMail(email);
                }
            }
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.info(sw.toString());
        }
    }

    @Async
    public void sendMail(Email email) {
        try {
            Destination destination = Destination.builder()
                    .toAddresses(email.getTo())
                    .bccAddresses(email.getBcc())
                    .ccAddresses(email.getCc())
                    .build();

            Content content = Content.builder()
                    .data(email.getBody())
                    .build();

            Content sub = Content.builder()
                    .data(email.getSubject())
                    .build();

            Body body = Body.builder()
                    .html(content)
                    .build();

            Message msg = Message.builder()
                    .subject(sub)
                    .body(body)
                    .build();

            SendEmailRequest emailRequest = SendEmailRequest.builder()
                    .destination(destination)
                    .message(msg)
                    .source(email.getFrom())
                    .build();
            logger.info("Attempting to send an email through Amazon SES " + "using the AWS SDK for Java...");
            SendEmailResponse resp = client.sendEmail(emailRequest);
            logger.info("Response : {} ", resp.messageId());
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.info(sw.toString());
        }
    }

}
