package com.example.FetcherSenderEmail.model.message.gmail;

public class MessagePartHeader {

    /**
     * The name of the header before the : separator. For example, To.
     * The value may be {@code null}.
     */
    private  String name;

    /**
     * The value of the header after the : separator. For example, someuser@example.com.
     * The value may be {@code null}.
     */
    private  String value;

    /**
     * The name of the header before the : separator. For example, To.
     * @return value or {@code null} for none
     */
    public String getName() {
        return name;
    }

    /**
     * The name of the header before the : separator. For example, To.
     * @param name name or {@code null} for none
     */
    public MessagePartHeader setName( String name) {
        this.name = name;
        return this;
    }

    /**
     * The value of the header after the : separator. For example, someuser@example.com.
     * @return value or {@code null} for none
     */
    public  String getValue() {
        return value;
    }

    /**
     * The value of the header after the : separator. For example, someuser@example.com.
     * @param value value or {@code null} for none
     */
    public MessagePartHeader setValue( String value) {
        this.value = value;
        return this;
    }

  /*  @Override
    public MessagePartHeader set(String fieldName, Object value) {
        return (MessagePartHeader) super.set(fieldName, value);
    }*/


}
