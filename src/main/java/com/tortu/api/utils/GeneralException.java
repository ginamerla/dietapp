package com.tortu.api.utils;

/**
 * Excepcion personalizada.
 *
 */
public class GeneralException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public GeneralException(String message){
        super(message);
    }
    public GeneralException(Throwable e) {
        super(e);
    }
    public GeneralException(String message, Throwable e) {
        super(message, e);
    }
    public GeneralException(String message, int code){}

    public String message;
    public int code;

//    @Override
//    public String getMessage() {
//        return message;
//    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}