package reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Adisorn on 17/3/2560.
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class RoomTypeNotAvailableException extends RuntimeException {

    public RoomTypeNotAvailableException() {
        super("No room type available for this reservation.");
    }

}
