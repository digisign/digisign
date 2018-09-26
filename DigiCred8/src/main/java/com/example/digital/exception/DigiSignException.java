package com.example.digital.exception;

public class DigiSignException extends RuntimeException {

    String reasonPhrase;
    String code;

    public DigiSignException(String message) {
        super(message);
    }

    public DigiSignException(Exception exception) {
        super(exception);
    }

    public DigiSignException(String message, Exception exception, String reasonPhrase, String code) {
        super(exception);
        this.code=code;
        this.reasonPhrase=reasonPhrase;
    }

    public DigiSignException( String reasonPhrase, String code) {
        super();
        this.code=code;
        this.reasonPhrase=reasonPhrase;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
