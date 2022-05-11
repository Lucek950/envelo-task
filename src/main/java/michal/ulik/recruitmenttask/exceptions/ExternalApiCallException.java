package michal.ulik.recruitmenttask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExternalApiCallException extends RuntimeException{
    public ExternalApiCallException() {
    }

    public ExternalApiCallException(String message) {
        super(message);
    }
}
