package com.example.FetcherSenderEmail.model.message.outlook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachment {

    private String name;
    private String contentType;
    private String contentBytes;
    private String dataType;

    public Attachment() {
    }
    @JsonProperty(value = "@odata.type")
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentBytes() {
        return contentBytes;
    }

    public void setContentBytes(String contentBytes) {
        this.contentBytes = contentBytes;
    }
}
