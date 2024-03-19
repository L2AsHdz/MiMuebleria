package com.ayd2.mimuebleria.exceptions;

public class NotFoundException extends ServiceException{
    public NotFoundException(){

    }

    public NotFoundException(String message){
        super(message);
    }
}
