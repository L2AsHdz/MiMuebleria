package com.ayd2.mimuebleria.exceptions;

public class DuplicatedEntityExeption extends ServiceException{
    public DuplicatedEntityExeption(){

    }
    public DuplicatedEntityExeption(String message){
        super(message);
    }
}
