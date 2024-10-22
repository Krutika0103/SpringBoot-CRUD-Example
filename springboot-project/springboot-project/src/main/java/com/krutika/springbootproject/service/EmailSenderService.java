package com.krutika.springbootproject.service;

import com.krutika.springbootproject.dto.MailRequest;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailSenderService   {


    @Autowired
    private JavaMailSender mailSender;

    public void sendMail( MailRequest mailRequest ) throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("krutikathakur0103@gmail.com", "dbtzucolgqgihtge");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("krutikathakur0103@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailRequest.getSendTo()));
        msg.setSubject (mailRequest.getSubject());
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(mailRequest.getBody(), "text/html");

        // Create the multipart object to hold both the text and attachment
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Add the file attachment if provided
        if (mailRequest.getAttachment() != null) {
            MimeBodyPart attachPart = new MimeBodyPart();
            attachPart.attachFile(convertMultipartFileToFile(mailRequest.getAttachment()));
            multipart.addBodyPart(attachPart);
        }


        msg.setContent(multipart);

        Transport.send(msg);
    }
    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(multipartFile.getBytes());
        }
        System.out.println("multipart file converted into file =="+file);
        return file;
    }

}

