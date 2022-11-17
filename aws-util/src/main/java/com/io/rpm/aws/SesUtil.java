package com.io.rpm.aws;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@Slf4j
@Component
public class SesUtil {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private final AmazonSimpleEmailService client;

    public SesUtil(AmazonSimpleEmailService client) {
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

    public String sendMail(Email email) {
        String message = "Success";
        String charSet = "UTF-8";
        try {
            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(new Destination().withToAddresses(email.getTo())
                            .withBccAddresses(email.getBcc() != null ? email.getBcc() : null)
                            .withCcAddresses(email.getCc() != null ? email.getCc() : null))
                    .withMessage(new Message().withBody(new Body().withHtml(new Content().withCharset(charSet).withData(email.getBody()))
                            .withText(new Content().withCharset(charSet).withData(email.getBody())))
                            .withSubject(new Content().withCharset(charSet).withData(email.getSubject())))
                    .withSource(email.getFrom());
            SendEmailResult result = client.sendEmail(request);
            message = "Success " + result.getMessageId();
            logger.info("Email sent success to {} ", email.getTo());
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.info(sw.toString());
            message = "Error";
            logger.info("Mail Sending failed to {} !!", email.getTo());
            logger.info("The email was not sent. Error message : {}", ex.getMessage());
        }
        return message;
    }

}
