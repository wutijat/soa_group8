package room.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Adisorn on 16/3/2560.
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ReservationNotConfirmException extends RuntimeException {

    public ReservationNotConfirmException(int reservationId) {
        super("This reservation id not yet confirmed The reservation: " + reservationId);
    }

}
