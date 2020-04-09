package com.example.FetcherSenderEmail.service;

import com.example.FetcherSenderEmail.httpclient.MyHttpClient;
import com.example.FetcherSenderEmail.model.message.outlook.*;
import com.example.FetcherSenderEmail.model.request.OutlookSendRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OutlookService {

    private String OUTLOOK_USER_ROOT_URL  = "https://graph.microsoft.com/v1.0/me/";
    private String OUTLOOK_MESSAGES_URL = OUTLOOK_USER_ROOT_URL+"messages" ;
    private String OUTLOOK_SEND_MAIL_URL = OUTLOOK_USER_ROOT_URL+"sendmail";

    @Autowired
    private MyHttpClient myHttpClient;

    @Value("${outlook.auth.access_token}")
    private String accessToken;

    @Value("${outlook.mail.receiver}")
    private String receiver;

    @Value("${outlook.mail.attachment.path}")
    private String attachmentPath;

    public String getListMessage() throws IOException, URISyntaxException {
        Map<String, String> header = new HashMap<>();
        Map<String, String> query = new HashMap<>();
        header.put("Authorization", accessToken);
        String response = myHttpClient.get(OUTLOOK_MESSAGES_URL, header, query);
        return response;
    }

    public String sendMailWithAttachMent() throws IOException {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", accessToken);
        header.put("Content-Type", "application/json");
        OutlookSendRequest outlookSendRequest = new OutlookSendRequest();
        OutlookMessage outlookMessage = new OutlookMessage();
        outlookMessage.setSubject("Test send message 23");
        MessageBody messageBody = new MessageBody();
        messageBody.setContent("Hello 23");
        messageBody.setContentType("text");
        EmailAddress emailAddress = new EmailAddress();
        Address address = new Address();
        address.setAddress(receiver);
        emailAddress.setEmailAddress(address);
        File file = new File(attachmentPath);
        byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        String encodeString = new String(encoded, StandardCharsets.US_ASCII);
        Attachment attachment = new Attachment();
        attachment.setContentBytes(encodeString);
        attachment.setDataType("#microsoft.graph.fileAttachment");
        attachment.setName(file.getName());
        outlookMessage.setBody(messageBody);
        List<Attachment> listAttachMent = new ArrayList<>();
        listAttachMent.add(attachment);
        outlookMessage.setAttachments(listAttachMent);
        List<EmailAddress> emailAddressList = new ArrayList<>();
        emailAddressList.add(emailAddress);
        outlookMessage.setToRecipients(emailAddressList);
        outlookSendRequest.setMessage(outlookMessage);
        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(outlookSendRequest);
        String response = myHttpClient.post(OUTLOOK_SEND_MAIL_URL, header, body);
        return response;
    }
}
