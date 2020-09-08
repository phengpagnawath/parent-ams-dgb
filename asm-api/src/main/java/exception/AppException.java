package exception;

import java.sql.Timestamp;

import com.wath.asmapi.rest.response.ErrorResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class AppException {
    
    @ExceptionHandler(value = ResponseStatusException.class)
    ResponseEntity<ErrorResponse> handle(ResponseStatusException e){
        ErrorResponse response = new ErrorResponse();

        response.setMessage("The operation faild, please check");
        response.setCode(e.getStatus().value());
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));
        response.setDetail(e.getMessage());

        return ResponseEntity.ok(response);
    }

}