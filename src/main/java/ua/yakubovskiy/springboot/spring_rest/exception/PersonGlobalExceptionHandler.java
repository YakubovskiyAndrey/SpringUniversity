package ua.yakubovskiy.springboot.spring_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PersonIncorrectData> handlerException(
            NoSuchPersonException exception){

        PersonIncorrectData data = new PersonIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PersonIncorrectData> handlerException(
            Exception exception){

        PersonIncorrectData data = new PersonIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
