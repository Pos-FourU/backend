package Pack01.global.exception;

import org.springframework.http.HttpStatus;

public class FourUPerMissionException extends FourUException {
    public FourUPerMissionException(String message) {
        super(message);
    }

    @Override
    public HttpStatus statusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
