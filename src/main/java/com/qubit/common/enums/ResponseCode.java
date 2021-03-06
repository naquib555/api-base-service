package com.qubit.common.enums;

public enum ResponseCode {
    OPERATION_SUCCESSFUL(100),
    OPERATION_FAILED(101),
    RECORD_NOT_FOUND(102),
    REQUEST_PARAM_MISSING(103),
    AUTHENTICATION_FAILED(1102),
    AUTHENTICATION_FAIL(107),
    UNAUTHORIZED_TOKEN(114),
    UNAUTHORIZED_ACCESS(118),
    INVALID_ARGUMENT(104),
    TOKEN_EXPIRED(115),
    SECURITY_ERROR(106),
    DATABASE_ERROR(110),
    RUNTIME_ERROR(500),
    REMOTE_ERROR(502),
    ORDER_CREATION_FAILED(109),
    ENROLLMENT_3DS_CHECK_FAILED(111),
    INTERNAL_CONNECTION_ERROR(503),
    ENROLLMENT_AUTHENTICATION_FAILED(112),
    ENROLLMENT_AUTHORIZATION_FAILED(113),
    TRANSACTION_FAILED(999);

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
