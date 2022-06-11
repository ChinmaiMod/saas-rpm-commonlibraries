package com.io.rpm.common.ses;//package com.io.holter.common.ses;
//
//import com.io.holter.common.dto.MailContentDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
//@Slf4j
//@Component
//@Configuration
//public class SesMailUtil {
//
//	@Autowired
//	private SesCredential credential;
//
////	public String sendMail1(MailContentDto contentDto) {
////
////		try {
////			AWSCredentials credentials = new BasicAWSCredentials(credential.getAwsKey(), credential.getAwsSecret());
////			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
////					.withRegion(credential.getAwsRegion())
////					.withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
////			SendEmailRequest request = new SendEmailRequest()
////					.withDestination(new Destination().withToAddresses(contentDto.getTo())
////							.withBccAddresses(contentDto.getBcc()).withCcAddresses(contentDto.getCc()))
////					.withMessage(new Message()
////							.withBody(new Body()
////									.withHtml(new Content().withCharset("UTF-8").withData(contentDto.getBody())))
////							.withSubject(new Content().withCharset("UTF-8").withData(contentDto.getSubject())))
////					.withSource(contentDto.getFromEmail());
////			client.sendEmail(request);
////			return "Sending mail done!!!";
////		} catch (Exception ex) {
////			System.out.println("The email was not sent.");
////			return "The email was not sent." + ex.getMessage();
////		}
////	}
//
//	public String sendEmail(MailContentDto contentDto) {
//
//		Properties props = System.getProperties();
//    	props.put("mail.transport.protocol", "smtp");
//    	props.put("mail.smtp.port", credential.getPort());
//    	props.put("mail.smtp.starttls.enable", "true");
//    	props.put("mail.smtp.auth", "true");
//
//        // Create a Session object to represent a mail session with the specified properties.
//    	Session session = Session.getDefaultInstance(props);
//
//        try
//        {
//			MimeMessage msg = new MimeMessage(session);
//			msg.setFrom(new InternetAddress(contentDto.getFromEmail(),contentDto.getFromEmail()));
//			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(contentDto.getTo().iterator().next()));
//			msg.setSubject(contentDto.getSubject());
//			msg.setContent(contentDto.getBody(),"text/html");
//			Transport transport = session.getTransport();
//            System.out.println("Sending...");
//
//            // Connect to Amazon SES using the SMTP username and password you specified above.
//            transport.connect(credential.getHost(), credential.getAwsKey(), credential.getAwsSecret());
//
//            // Send the email.
//            transport.sendMessage(msg, msg.getAllRecipients());
//            System.out.println("Email sent!");
//            return "Email Sent !";
//        }
//        catch (Exception ex) {
//            System.out.println("The email was not sent.");
//            System.out.println("Error message: " + ex.getMessage());
//
//			return "The email was not sent." + ex.getMessage();
//        }
//
//	}
//}
