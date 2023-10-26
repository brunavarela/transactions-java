package br.com.bruna.learningspring.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatusCode status, final WebRequest request) {

        final HashMap<String, HashMap> returnObject = new HashMap<>();
        final HashMap<String, String> allErrorsObject = new HashMap<>();

        final List<ObjectError> allErrorsList = ex.getAllErrors();

        allErrorsList.forEach(error -> {
            if (error instanceof FieldError) {
                allErrorsObject.put(((FieldError) error).getField(), error.getDefaultMessage());
            } else {
                allErrorsObject.put(error.getObjectName(), error.getDefaultMessage());
            }
        });

        returnObject.put("message", allErrorsObject);

        return new ResponseEntity<>(returnObject, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({AppException.class})
    public ResponseEntity<Object> handlerAppException(final AppException ex) {

        final HashMap<String, String> returnObject = new HashMap<>();
        returnObject.put("message", ex.getMessage());

        System.out.println(ex.getMessage());

        return new ResponseEntity<>(returnObject, ex.getStatusCode());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handlerInternal(final RuntimeException ex) {

        final HashMap<String, String> returnObject = new HashMap<>();
        returnObject.put("message", "Internal Server Error");

        System.out.println(ex.getMessage());

        return new ResponseEntity<>(returnObject, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
