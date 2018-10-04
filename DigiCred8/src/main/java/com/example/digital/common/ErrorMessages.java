package com.example.digital.common;

public enum ErrorMessages {

    USER_ALREADY_EXISTS("DIG-001", "user already exists"),
    WRONG_CREDENTIALS("DIG-002", "wrong credentials"),
    LEARNER_NOT_AVAILABLE("DIG-003", "learner with id doesn't exist"),
    COURSE_NOT_AVAILABLE("DIG-004", "course with id doesn't exist"),
    GRADE_NOT_AVAILABLE("DIG-005", "grade with id doesn't exist"),
    INSTITUION_NOT_AVAILABLE("DIG-005", "institution with id doesn't exist"),
    USER_NOT_AVAILABLE("DIG-006", "user with email doesn't exist"),
    STATUS_NOT_AVAILABLE("DIG-007", "status with id doesn't exist"),
    FILE_NAME_NOT_AVAILABLE("DIG-007", "file with name does not exist"),
    RESOURCE_NOT_AVAILABLE("DIG-008", "resource with id doesnot exist"),
    MARKS_TYPE_NOT_AVAILABLE("DIG-009","marks type id doesn't exist"),
    ACCOUNT_NOT_VERIFIED("DIG-010","account is not verified"),
    PAGINATED_PARAMS_NOT_AVALABLE("DIG-008", "pagination params not available"),
    TOKEN_DOES_NOT_EXIST("DIG-011","token is invalid");




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
