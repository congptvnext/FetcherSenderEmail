package com.example.FetcherSenderEmail.model.message.gmail;

import java.math.BigInteger;
import java.util.List;

public class Message {
    /**
     * The ID of the last history record that modified this message.
     * The value may be {@code null}.
     */
    private BigInteger historyId;

    /**
     * The immutable ID of the message.
     * The value may be {@code null}.
     */
    private  String id;

    /**
     * The internal message creation timestamp (epoch ms), which determines ordering in the inbox. For
     * normal SMTP-received email, this represents the time the message was originally accepted by
     * Google, which is more reliable than the Date header. However, for API-migrated mail, it can be
     * configured by client to be based on the Date header.
     * The value may be {@code null}.
     */
    private  Long internalDate;

    /**
     * List of IDs of labels applied to this message.
     * The value may be {@code null}.
     */
    private  List< String> labelIds;

    /**
     * The parsed email structure in the message parts.
     * The value may be {@code null}.
     */
    private MessagePart payload;

    /**
     * The entire email message in an RFC 2822 formatted and base64url encoded string. Returned in
     * messages.get and drafts.get responses when the format=RAW parameter is supplied.
     * The value may be {@code null}.
     */
    private  String raw;

    /**
     * Estimated size in bytes of the message.
     * The value may be {@code null}.
     */
    private  Integer sizeEstimate;

    /**
     * A short part of the message text.
     * The value may be {@code null}.
     */
    private String snippet;

    /**
     * The ID of the thread the message belongs to. To add a message or draft to a thread, the
     * following criteria must be met: - The requested threadId must be specified on the Message or
     * Draft.Message you supply with your request.  - The References and In-Reply-To headers must be
     * set in compliance with the RFC 2822 standard.  - The Subject headers must match.
     * The value may be {@code null}.
     */
    private  String threadId;

    /**
     * The ID of the last history record that modified this message.
     * @return value or {@code null} for none
     */
    public  BigInteger getHistoryId() {
        return historyId;
    }

    /**
     * The ID of the last history record that modified this message.
     * @param historyId historyId or {@code null} for none
     */
    public Message setHistoryId(BigInteger historyId) {
        this.historyId = historyId;
        return this;
    }

    /**
     * The immutable ID of the message.
     * @return value or {@code null} for none
     */
    public  String getId() {
        return id;
    }

    /**
     * The immutable ID of the message.
     * @param id id or {@code null} for none
     */
    public Message setId( String id) {
        this.id = id;
        return this;
    }

    /**
     * The internal message creation timestamp (epoch ms), which determines ordering in the inbox. For
     * normal SMTP-received email, this represents the time the message was originally accepted by
     * Google, which is more reliable than the Date header. However, for API-migrated mail, it can be
     * configured by client to be based on the Date header.
     * @return value or {@code null} for none
     */
    public  Long getInternalDate() {
        return internalDate;
    }

    /**
     * The internal message creation timestamp (epoch ms), which determines ordering in the inbox. For
     * normal SMTP-received email, this represents the time the message was originally accepted by
     * Google, which is more reliable than the Date header. However, for API-migrated mail, it can be
     * configured by client to be based on the Date header.
     * @param internalDate internalDate or {@code null} for none
     */
    public Message setInternalDate(Long internalDate) {
        this.internalDate = internalDate;
        return this;
    }

    /**
     * List of IDs of labels applied to this message.
     * @return value or {@code null} for none
     */
    public  List<String> getLabelIds() {
        return labelIds;
    }

    /**
     * List of IDs of labels applied to this message.
     * @param labelIds labelIds or {@code null} for none
     */
    public Message setLabelIds( List<String> labelIds) {
        this.labelIds = labelIds;
        return this;
    }

    /**
     * The parsed email structure in the message parts.
     * @return value or {@code null} for none
     */
    public MessagePart getPayload() {
        return payload;
    }

    /**
     * The parsed email structure in the message parts.
     * @param payload payload or {@code null} for none
     */
    public Message setPayload(MessagePart payload) {
        this.payload = payload;
        return this;
    }

    /**
     * The entire email message in an RFC 2822 formatted and base64url encoded string. Returned in
     * messages.get and drafts.get responses when the format=RAW parameter is supplied.
     * @return value or {@code null} for none
     */
    public  String getRaw() {
        return raw;
    }

    /**
     * The entire email message in an RFC 2822 formatted and base64url encoded string. Returned in
     * messages.get and drafts.get responses when the format=RAW parameter is supplied.
     * @see #getRaw()
     * @return Base64 decoded value or {@code null} for none
     *
     * @since 1.14
     */
  /*  public byte[] decodeRaw() {
        return com.google.api.client.util.Base64.decodeBase64(raw);
    }
*/
    /**
     * The entire email message in an RFC 2822 formatted and base64url encoded string. Returned in
     * messages.get and drafts.get responses when the format=RAW parameter is supplied.
     * @param raw raw or {@code null} for none
     */
    public Message setRaw(String raw) {
        this.raw = raw;
        return this;
    }

    /**
     * The entire email message in an RFC 2822 formatted and base64url encoded string. Returned in
     * messages.get and drafts.get responses when the format=RAW parameter is supplied.
     *
     * <p>
     * The value is encoded Base64 or {@code null} for none.
     * </p>
     *
     * @since 1.14
     */
   /* public Message encodeRaw(byte[] raw) {
        this.raw = com.google.api.client.util.Base64.encodeBase64URLSafeString(raw);
        return this;
    }
*/
    /**
     * Estimated size in bytes of the message.
     * @return value or {@code null} for none
     */
    public Integer getSizeEstimate() {
        return sizeEstimate;
    }

    /**
     * Estimated size in bytes of the message.
     * @param sizeEstimate sizeEstimate or {@code null} for none
     */
    public Message setSizeEstimate(Integer sizeEstimate) {
        this.sizeEstimate = sizeEstimate;
        return this;
    }

    /**
     * A short part of the message text.
     * @return value or {@code null} for none
     */
    public  String getSnippet() {
        return snippet;
    }

    /**
     * A short part of the message text.
     * @param snippet snippet or {@code null} for none
     */
    public Message setSnippet(String snippet) {
        this.snippet = snippet;
        return this;
    }

    /**
     * The ID of the thread the message belongs to. To add a message or draft to a thread, the
     * following criteria must be met: - The requested threadId must be specified on the Message or
     * Draft.Message you supply with your request.  - The References and In-Reply-To headers must be
     * set in compliance with the RFC 2822 standard.  - The Subject headers must match.
     * @return value or {@code null} for none
     */
    public String getThreadId() {
        return threadId;
    }

    /**
     * The ID of the thread the message belongs to. To add a message or draft to a thread, the
     * following criteria must be met: - The requested threadId must be specified on the Message or
     * Draft.Message you supply with your request.  - The References and In-Reply-To headers must be
     * set in compliance with the RFC 2822 standard.  - The Subject headers must match.
     * @param threadId threadId or {@code null} for none
     */
    public Message setThreadId(String threadId) {
        this.threadId = threadId;
        return this;
    }

   /* @Override
    public Message set(String fieldName, Object value) {
        return (Message) super.set(fieldName, value);
    }

    @Override
    public Message clone() {
        return (Message) super.clone();
    }*/

}
