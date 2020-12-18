package store.Products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import store.Products.exception.utils.ProductNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<Object> productValidation(ProductNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage()+ " at " + LocalDateTime.now());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> retrieveValidation(MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest()
                .body("Invalid value: " + exception.getFieldError().getRejectedValue() +
                        " for field " + exception.getFieldError().getField() +
                        " with message " + exception.getFieldError().getDefaultMessage());
    }

}
