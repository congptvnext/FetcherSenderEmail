package com.example.FetcherSenderEmail.model.message.outlook;
import java.util.List;

public class OutlookMessage {

    private String subject;
    private MessageBody body;
    private List<EmailAddress> toRecipients;
    private List<Attachment> attachments;

    public OutlookMessage() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MessageBody getBody() {
        return body;
    }

    public void setBody(MessageBody body) {
        this.body = body;
    }

    public List<EmailAddress> getToRecipients() {
        return toRecipients;
    }

    public void setToRecipients(List<EmailAddress> toRecipients) {
        this.toRecipients = toRecipients;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
