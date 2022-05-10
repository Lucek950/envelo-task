package michal.ulik.recruitmenttask.exceptions;


public class RateNotFoundException extends RuntimeException {
    public RateNotFoundException() {
    }

    public RateNotFoundException(String message) {
        super(message);
    }
}
