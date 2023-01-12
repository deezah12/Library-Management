package semicolon.africa.librarymanagement.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApiError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    public  ApiError(){
        timeStamp = LocalDateTime.now();
    }
    ApiError(HttpStatus httpStatus){
        this();
        this.status = httpStatus;
    }
    ApiError(HttpStatus httpStatus,Throwable ex){
        this();
        this.status = httpStatus;
        this.message = "unexpected message";
        this.debugMessage = ex.getLocalizedMessage();
    }
    ApiError(HttpStatus httpStatus, String message, Throwable ex){
        this();
        this.status = httpStatus;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}
