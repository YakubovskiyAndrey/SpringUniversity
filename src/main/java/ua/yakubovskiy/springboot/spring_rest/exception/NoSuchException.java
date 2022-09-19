package ua.yakubovskiy.springboot.spring_rest.exception;

public class NoSuchException extends RuntimeException{

    public NoSuchException(String message) {
        super(message);
    }
}
