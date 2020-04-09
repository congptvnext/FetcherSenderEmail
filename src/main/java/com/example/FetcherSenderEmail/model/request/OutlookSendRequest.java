package com.example.FetcherSenderEmail.model.request;


import com.example.FetcherSenderEmail.model.message.outlook.OutlookMessage;

public class OutlookSendRequest {

    private OutlookMessage message;

    public OutlookSendRequest() {
    }

    public OutlookMessage getMessage() {
        return message;
    }

    public void setMessage(OutlookMessage message) {
        this.message = message;
    }
}
