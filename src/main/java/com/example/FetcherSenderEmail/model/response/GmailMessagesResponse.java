package com.example.FetcherSenderEmail.model.response;


import com.example.FetcherSenderEmail.model.message.gmail.Message;

import java.util.List;

public class GmailMessagesResponse {

    private List<Message> messages;
    private String nextPageToken;
    private int resultSizeEstimate;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public int getResultSizeEstimate() {
        return resultSizeEstimate;
    }

    public void setResultSizeEstimate(int resultSizeEstimate) {
        this.resultSizeEstimate = resultSizeEstimate;
    }

    public GmailMessagesResponse() {
    }
}
