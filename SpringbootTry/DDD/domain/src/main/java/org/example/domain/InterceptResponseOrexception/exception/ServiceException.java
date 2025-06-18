package org.example.domain.InterceptResponseOrexception.exception;


public class ServiceException extends  Exception {

    private String code;

    public ServiceException() {
    }

    public ServiceException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
