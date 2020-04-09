package com.example.FetcherSenderEmail.model.message.outlook;

public class MessageBody {
    private String contentType;
    private String content;

    public MessageBody() {
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
