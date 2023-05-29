package com.example.homework2.general;

import com.example.homework2.exception.ProductCommentNotFoundExc;
import com.example.homework2.exception.UserCommentNotFoundExc;
import com.example.homework2.exception.UsernameAndPhoneNumNotMatch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<GenericErrorMessage> handleUsernameAndPhoneNumberNotMatchingException(UsernameAndPhoneNumNotMatch e, WebRequest webRequest) {

        String message = e.getErrorMessage();
        String description = webRequest.getDescription(false);

        var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);

        return ResponseEntity.internalServerError().body(genericErrorMessage);
    }

    @ExceptionHandler
    public final ResponseEntity<GenericErrorMessage> handleUserCommentsNotFoundException(UserCommentNotFoundExc e, WebRequest webRequest) {

        String message = e.getErrorMessage();
        String description = webRequest.getDescription(false);

        var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);

        return ResponseEntity.internalServerError().body(genericErrorMessage);
    }
    @ExceptionHandler
    public final ResponseEntity<GenericErrorMessage> handleProductCommentsNotFoundException(ProductCommentNotFoundExc e, WebRequest webRequest) {

        String message = e.getErrorMessage();
        String description = webRequest.getDescription(false);

        var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);

        return ResponseEntity.internalServerError().body(genericErrorMessage);
    }

}
