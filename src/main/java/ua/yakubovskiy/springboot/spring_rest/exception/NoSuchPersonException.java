package ua.yakubovskiy.springboot.spring_rest.exception;

public class NoSuchPersonException extends RuntimeException{


    public NoSuchPersonException(String message) {
        super(message);
    }
}
