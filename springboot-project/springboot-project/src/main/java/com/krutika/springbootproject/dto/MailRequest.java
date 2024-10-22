package com.krutika.springbootproject.dto;

import jakarta.mail.Multipart;
import org.springframework.web.multipart.MultipartFile;

public class MailRequest {

    private String sendTo;
    private String content;

    private String subject;
    private String body;

    private MultipartFile attachment ;

    public MultipartFile getAttachment() {
        return attachment;
    }

    public void setAttachment(MultipartFile attachment) {
        this.attachment = attachment;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "MailRequest{" +
                "sendTo='" + sendTo + '\'' +
                ", content='" + content + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", attachment=" + attachment +
                '}';
    }
}
