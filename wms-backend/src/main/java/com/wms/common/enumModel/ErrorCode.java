package com.wms.common.enumModel;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SUCCESS("0", STATUS.SUCCESSFUL, "Sucess"),

    BUSINESS_EXCEPTION_001("BE001", STATUS.FAILED, "User Not Found."),
    BUSINESS_EXCEPTION_002("BE002", STATUS.FAILED, "User Mapper Error."),
    BUSINESS_EXCEPTION_003("BE003", STATUS.FAILED, "Username Not Valid."),
    BUSINESS_EXCEPTION_004("BE004", STATUS.FAILED, "Password Not Valid.");

    private final String errorCode;
    private final STATUS status;
    private final String errorDescription;

    ErrorCode(String errorCode, STATUS status, String errorDescription) {
        this.errorCode = errorCode;
        this.status = status;
        this.errorDescription = errorDescription;
    }
}
