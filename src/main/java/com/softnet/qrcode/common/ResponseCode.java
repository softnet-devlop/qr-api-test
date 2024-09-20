package com.softnet.qrcode.common;

public enum  ResponseCode {

    OK(200, "Success"), // 성공
    BAD_REQUEST(400, "Invalid request parameters supplied."), // 잘못된 파라미터
    RESOURCE_NOT_FOUND(404, "Resource not found"),
    INTERNAL_SERVER(500, "Internal server error."); // 서버 내부 오류

    private int code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
