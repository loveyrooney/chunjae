package Exceptions;

import java.io.IOException;

public class CustomIOException extends IOException {
    public CustomIOException(String msg){
        super(msg);
        System.out.println("custom exception 에서 해결");
    }
}
