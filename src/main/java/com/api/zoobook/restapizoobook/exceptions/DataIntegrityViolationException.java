package com.api.zoobook.restapizoobook.exceptions;

public class DataIntegrityViolationException extends RuntimeException{

    public DataIntegrityViolationException(String msg){
        super(msg);
    }

    public DataIntegrityViolationException(String msg, Throwable cause){
        super(msg, cause);
    }

}
