package com.example.FetcherSenderEmail.service;

import com.example.FetcherSenderEmail.httpclient.MyHttpClient;
import com.example.FetcherSenderEmail.model.message.gmail.Message;
import com.example.FetcherSenderEmail.model.request.GmailSendRequest;
import com.example.FetcherSenderEmail.model.response.GmailMessagesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class GmailService {
    private String GMAIL_USER_ROOT_URL = "https://www.googleapis.com/gmail/v1/users/me/";
    private String GMAIL_MESSAGES_URL = GMAIL_USER_ROOT_URL + "messages/";
    private String GMAIL_SEND_MESSAGE_URL = GMAIL_MESSAGES_URL + "send";

    @Autowired
    private MyHttpClient myHttpClient;

    @Value("${gmail.auth.access_token}")
    private String accessToken;

    @Value("${gmail.mail.sender}")
    private String sender;

    @Value("${gmail.mail.receiver}")
    private String receiver;

    @Value("${gmail.mail.attachment.path}")
    private String attachmentPath;


    public MimeMessage createMessageWithAttachment(String to, String from, String subject, String bodyText, File attachment) throws MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(bodyText, "text/plain");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        mimeBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(attachment);
        mimeBodyPart.setDataHandler(new DataHandler(source));
        mimeBodyPart.setFileName(attachment.getName());
        multipart.addBodyPart(mimeBodyPart);
        email.setContent(multipart);
        return email;
    }

    public String sendMailWithAttachMent()
            throws MessagingException, IOException {
        File file = new File(attachmentPath);
        MimeMessage emailContent = createMessageWithAttachment(
                receiver,
                sender,
                "Test send mail subject",
                "Test send mail body text",
                file
        );
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        emailContent.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", accessToken);
        header.put("Content-Type", "application/json");
        GmailSendRequest gmailSendRequest = new GmailSendRequest();
        ObjectMapper mapper = new ObjectMapper();
        gmailSendRequest.setRaw(encodedEmail);
        String body = mapper.writeValueAsString(gmailSendRequest);
        String response = myHttpClient.post(GMAIL_SEND_MESSAGE_URL, header, body);
        return response;
    }

    public String getListMessage() throws IOException, URISyntaxException {
        StringBuilder result = new StringBuilder();
        Map<String, String> header = new HashMap<>();
        Map<String, String> query = new HashMap<>();
        header.put("Authorization", accessToken);
        query.put("maxResults", "10");
        String response = myHttpClient.get(GMAIL_MESSAGES_URL, header, query);
        ObjectMapper mapper = new ObjectMapper();
        GmailMessagesResponse messages = mapper.readValue(response, GmailMessagesResponse.class);
        if (messages != null) {
            for (Message message : messages.getMessages()) {
                String messageResponse = getMessageDetail(header, message.getId());
                Message messageDetail = mapper.readValue(messageResponse, Message.class);
                result.append(messageDetail.getSnippet());
            }
        }
        return result.toString();
    }

    public String getMessageDetail(Map<String, String> header, String id) throws IOException, URISyntaxException {
        String messageResponse = myHttpClient.get(GMAIL_MESSAGES_URL + id, header, null);
        return messageResponse;
    }

}
