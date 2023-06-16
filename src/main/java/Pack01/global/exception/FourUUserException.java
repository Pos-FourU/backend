package Pack01.global.exception;

import org.springframework.http.HttpStatus;

public class FourUUserException extends FourUException {
    public FourUUserException(String message) {
        super(message);
    }

    @Override
    public HttpStatus statusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
