package com.example.FetcherSenderEmail.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;
@Component
public class MyHttpClient {
    public String post(String url, Map<String, String> header, String body) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        Set<String> keys = header.keySet();
        for (String key : keys) {
            httppost.addHeader(key, header.get(key));
        }
        if (body != null) {
            StringEntity params =new StringEntity(body);
            httppost.setEntity(params);
        }
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        StringBuilder content = new StringBuilder();
        if (entity != null) {
            try (InputStream instream = entity.getContent();
                 Reader reader = new BufferedReader(new InputStreamReader
                         (instream, Charset.forName(StandardCharsets.UTF_8.name())))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    content.append((char) c);
                }
            }
        }
        return content.toString();
    }

    public String get(String url, Map<String, String> header, Map<String, String> query) throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder(url);
        if (query != null) {
            for (String key : query.keySet()) {
                builder.setParameter(key, query.get(key));
            }
        }
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(builder.build());
        if (header != null) {
            for (String key : header.keySet()) {
                httpGet.addHeader(key, header.get(key));
            }
        }
        HttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        StringBuilder content = new StringBuilder();
        if (entity != null) {
            try (InputStream instream = entity.getContent();
                 Reader reader = new BufferedReader(new InputStreamReader
                         (instream, Charset.forName(StandardCharsets.UTF_8.name())))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    content.append((char) c);
                }
            }
        }
        return content.toString();
    }
}
