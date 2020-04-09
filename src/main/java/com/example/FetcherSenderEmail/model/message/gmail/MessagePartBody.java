package com.example.FetcherSenderEmail.model.message.gmail;
public class MessagePartBody {

    /**
     * When present, contains the ID of an external attachment that can be retrieved in a separate
     * messages.attachments.get request. When not present, the entire content of the message part body
     * is contained in the data field.
     * The value may be {@code null}.
     */
    private String attachmentId;

    /**
     * The body data of a MIME message part as a base64url encoded string. May be empty for MIME
     * container types that have no message body or when the body data is sent as a separate
     * attachment. An attachment ID is present if the body data is contained in a separate attachment.
     * The value may be {@code null}.
     */
    private  String data;

    /**
     * Number of bytes for the message part data (encoding notwithstanding).
     * The value may be {@code null}.
     */
    private  Integer size;

    /**
     * When present, contains the ID of an external attachment that can be retrieved in a separate
     * messages.attachments.get request. When not present, the entire content of the message part body
     * is contained in the data field.
     * @return value or {@code null} for none
     */
    public  String getAttachmentId() {
        return attachmentId;
    }

    /**
     * When present, contains the ID of an external attachment that can be retrieved in a separate
     * messages.attachments.get request. When not present, the entire content of the message part body
     * is contained in the data field.
     * @param attachmentId attachmentId or {@code null} for none
     */
    public MessagePartBody setAttachmentId( String attachmentId) {
        this.attachmentId = attachmentId;
        return this;
    }

    /**
     * The body data of a MIME message part as a base64url encoded string. May be empty for MIME
     * container types that have no message body or when the body data is sent as a separate
     * attachment. An attachment ID is present if the body data is contained in a separate attachment.
     * @return value or {@code null} for none
     */
    public  String getData() {
        return data;
    }

    /**
     * The body data of a MIME message part as a base64url encoded string. May be empty for MIME
     * container types that have no message body or when the body data is sent as a separate
     * attachment. An attachment ID is present if the body data is contained in a separate attachment.
     * @see #getData()
     * @return Base64 decoded value or {@code null} for none
     *
     * @since 1.14
     */
   /* public byte[] decodeData() {
        return com.google.api.client.util.Base64.decodeBase64(data);
    }*/

    /**
     * The body data of a MIME message part as a base64url encoded string. May be empty for MIME
     * container types that have no message body or when the body data is sent as a separate
     * attachment. An attachment ID is present if the body data is contained in a separate attachment.
     * @param data data or {@code null} for none
     */
    public MessagePartBody setData( String data) {
        this.data = data;
        return this;
    }

    /**
     * The body data of a MIME message part as a base64url encoded string. May be empty for MIME
     * container types that have no message body or when the body data is sent as a separate
     * attachment. An attachment ID is present if the body data is contained in a separate attachment.
     * @see #setData()
     *
     * <p>
     * The value is encoded Base64 or {@code null} for none.
     * </p>
     *
     * @since 1.14
     */
   /* public MessagePartBody encodeData(byte[] data) {
        this.data = com.google.api.client.util.Base64.encodeBase64URLSafeString(data);
        return this;
    }
*/
    /**
     * Number of bytes for the message part data (encoding notwithstanding).
     * @return value or {@code null} for none
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Number of bytes for the message part data (encoding notwithstanding).
     * @param size size or {@code null} for none
     */
    public MessagePartBody setSize( Integer size) {
        this.size = size;
        return this;
    }

 /*   @Override
    public MessagePartBody set(String fieldName, Object value) {
        return (MessagePartBody) super.set(fieldName, value);
    }

    @Override
    public MessagePartBody clone() {
        return (MessagePartBody) super.clone();
    }*/

}
