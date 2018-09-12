package com.example.digital.common;

public enum ErrorMessages {

    USER_ALREADY_EXISTS("DIG-001", "user already exists"),
    WRONG_CREDENTIALS("DIG-002", "wrong credentials"),
    LEARNER_NOT_AVAILABLE("DIG-003", "learner with id doesn't exist"),
    COURSE_NOT_AVAILABLE("DIG-004", "course with id doesn't exist"),
    GRADE_NOT_AVAILABLE("DIG-005", "grade with id doesn't exist"),
    INSTITUION_NOT_AVAILABLE("DIG-005", "institution with id doesn't exist");


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
