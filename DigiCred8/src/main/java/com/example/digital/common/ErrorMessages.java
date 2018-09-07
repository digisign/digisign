package com.example.digital.common;

public enum ErrorMessages {
    FILE_NOT_FOUND("MEA-001", "Error in getting Ftp file"),
    ID_MISSING("ID doesn't meet query conditions"),
    EMAIL_MISSING("EMAIL doesn't meet query conditions"),
    DOMAIN_MISSING("Domain name validation  failed"),
    EMAIL_NULL("email is null in db or empty"),
    EMAIL_ID_NOT_MATCHING("email,Id do not  match"),
    USER_ALREADY_EXISTS("DIG-001","user already exists"),
    WRONG_CREDENTIALS("DIG-001","wrong credentials");


    private final String code;
    private final String reasonPhrase;

    ErrorMessages(String code, String reasonPhrase) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }

    ErrorMessages(String reasonPhrase) {
        this(reasonPhrase, reasonPhrase);
    }

    public String getCode() {
        return this.code;
    }
    public String getReasonPhrase() {
        return this.reasonPhrase;
    }


}
