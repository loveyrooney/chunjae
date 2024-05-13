package com.chunjae.logs.exception;

// @ResponseStatus(HttpStatus.NOT_FOUND) 이런 식으로 붙이면 500 에러를 404 에러로 상정해 클라이언트에 보낼수 있음
public class NoFileException extends Exception{
    public NoFileException(){
        super("NoFileException");
    }
}
