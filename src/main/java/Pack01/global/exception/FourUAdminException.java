package Pack01.global.exception;

import org.springframework.http.HttpStatus;

public class FourUAdminException extends FourUException {
    public FourUAdminException(String message) {
        super(message);
    }

    @Override
    public HttpStatus statusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
