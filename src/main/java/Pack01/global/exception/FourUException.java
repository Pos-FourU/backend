package Pack01.global.exception;

import org.springframework.http.HttpStatus;

public abstract class FourUException extends RuntimeException{
    public FourUException(String message) {
        super(message);
    }

    public abstract HttpStatus statusCode();
}
