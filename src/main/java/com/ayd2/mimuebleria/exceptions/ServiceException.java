package com.ayd2.mimuebleria.exceptions;

public class ServiceException extends Exception{
    public ServiceException(){

    }

    public ServiceException(String message){
        super(message);
    }
}
