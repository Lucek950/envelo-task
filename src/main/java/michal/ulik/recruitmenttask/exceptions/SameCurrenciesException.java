package michal.ulik.recruitmenttask.exceptions;

import java.util.function.Supplier;

public class SameCurrenciesException extends RuntimeException{
    public SameCurrenciesException() {
    }

    public SameCurrenciesException(String message) {
        super(message);
    }
}
