package com.example.FetcherSenderEmail.controller;

import com.example.FetcherSenderEmail.service.GmailService;
import com.example.FetcherSenderEmail.service.OutlookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class MyController {
    @Autowired
    private GmailService gmailService;

    @Autowired
    private OutlookService outlookService;

    @GetMapping(value = "/fetchMailFromGmail")
    public String fetchMailFromGmail() throws IOException, URISyntaxException {
        String response = gmailService.getListMessage();
        return response;
    }

    @GetMapping(value = "/fetchMailFromOffice")
    public String fetchMailFromOffice() throws IOException, URISyntaxException {
        String response = outlookService.getListMessage();
        return response;
    }

    @GetMapping(value = "/sendMailFromGmail")
    public String sendMailFromGmail() throws IOException, MessagingException {
        String response = gmailService.sendMailWithAttachMent();
        return response;
    }

    @GetMapping(value = "/sendMailFromOutLook")
    public String sendMailFromOutLook() throws IOException {
        String response = outlookService.sendMailWithAttachMent();
        return response;
    }

}
