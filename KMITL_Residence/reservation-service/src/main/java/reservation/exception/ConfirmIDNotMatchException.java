package reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Adisorn on 20/3/2560.
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ConfirmIDNotMatchException extends RuntimeException {
    public ConfirmIDNotMatchException(int reservationId) {
        super("Confirm ID not match: " + reservationId);
    }
}
