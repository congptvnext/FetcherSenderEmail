package com.example.FetcherSenderEmail.model.message.gmail;
import java.util.List;

public class MessagePart {

    /**
     * The message part body for this part, which may be empty for container MIME message parts.
     * The value may be {@code null}.
     */
    private MessagePartBody body;

    /**
     * The filename of the attachment. Only present if this message part represents an attachment.
     * The value may be {@code null}.
     */
    private String filename;

    /**
     * List of headers on this message part. For the top-level message part, representing the entire
     * message payload, it will contain the standard RFC 2822 email headers such as To, From, and
     * Subject.
     * The value may be {@code null}.
     */
    private List<MessagePartHeader> headers;

    /**
     * The MIME type of the message part.
     * The value may be {@code null}.
     */
    private  String mimeType;

    /**
     * The immutable ID of the message part.
     * The value may be {@code null}.
     */
    private String partId;

    /**
     * The child MIME message parts of this part. This only applies to container MIME message parts,
     * for example multipart. For non- container MIME message part types, such as text/plain, this
     * field is empty. For more information, see RFC 1521.
     * The value may be {@code null}.
     */
    private  List<MessagePart> parts;

    /**
     * The message part body for this part, which may be empty for container MIME message parts.
     * @return value or {@code null} for none
     */
    public MessagePartBody getBody() {
        return body;
    }

    /**
     * The message part body for this part, which may be empty for container MIME message parts.
     * @param body body or {@code null} for none
     */
    public MessagePart setBody(MessagePartBody body) {
        this.body = body;
        return this;
    }

    /**
     * The filename of the attachment. Only present if this message part represents an attachment.
     * @return value or {@code null} for none
     */
    public  String getFilename() {
        return filename;
    }

    /**
     * The filename of the attachment. Only present if this message part represents an attachment.
     * @param filename filename or {@code null} for none
     */
    public MessagePart setFilename( String filename) {
        this.filename = filename;
        return this;
    }

    /**
     * List of headers on this message part. For the top-level message part, representing the entire
     * message payload, it will contain the standard RFC 2822 email headers such as To, From, and
     * Subject.
     * @return value or {@code null} for none
     */
    public  List<MessagePartHeader> getHeaders() {
        return headers;
    }

    /**
     * List of headers on this message part. For the top-level message part, representing the entire
     * message payload, it will contain the standard RFC 2822 email headers such as To, From, and
     * Subject.
     * @param headers headers or {@code null} for none
     */
    public MessagePart setHeaders( List<MessagePartHeader> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * The MIME type of the message part.
     * @return value or {@code null} for none
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * The MIME type of the message part.
     * @param mimeType mimeType or {@code null} for none
     */
    public MessagePart setMimeType( String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    /**
     * The immutable ID of the message part.
     * @return value or {@code null} for none
     */
    public  String getPartId() {
        return partId;
    }

    /**
     * The immutable ID of the message part.
     * @param partId partId or {@code null} for none
     */
    public MessagePart setPartId( String partId) {
        this.partId = partId;
        return this;
    }

    /**
     * The child MIME message parts of this part. This only applies to container MIME message parts,
     * for example multipart. For non- container MIME message part types, such as text/plain, this
     * field is empty. For more information, see RFC 1521.
     * @return value or {@code null} for none
     */
    public List<MessagePart> getParts() {
        return parts;
    }

    /**
     * The child MIME message parts of this part. This only applies to container MIME message parts,
     * for example multipart. For non- container MIME message part types, such as text/plain, this
     * field is empty. For more information, see RFC 1521.
     * @param parts parts or {@code null} for none
     */
    public MessagePart setParts( List<MessagePart> parts) {
        this.parts = parts;
        return this;
    }

   /* @Override
    public MessagePart set(String fieldName, Object value) {
        return (MessagePart) super.set(fieldName, value);
    }

    @Override
    public MessagePart clone() {
        return (MessagePart) super.clone();
    }*/
}
