package reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservation.model.AvailableRoomsType;
import reservation.model.RoomType;
import reservation.repository.ReservationRepository;
import reservation.model.Reservation;
import reservation.model.ReservationDetail;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Adisorn on 1/3/2560.
 */
@RestController
@CrossOrigin(origins = "*")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping("/reservation/{reservation_id}")
    public ReservationDetail getReservation(@PathVariable String reservation_id) {
        return this.reservationRepository.getReservation(Integer.valueOf(reservation_id));
    }

    @RequestMapping(value = "/reservation/add",method = RequestMethod.POST)
    public ResponseEntity saveReservation(@RequestBody Reservation reservation) {
        if(reservation != null) {
            reservationRepository.saveReservation(reservation);
        }
        else {
            System.out.print("Null");
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reservation/{reservation_id}/confirm", method = RequestMethod.PUT)
    public ResponseEntity confirmReservation(@PathVariable String reservation_id) {
        reservationRepository.confirmReservation(Integer.valueOf(reservation_id));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/reservation/{reservation_id}/cancel", method = RequestMethod.PUT)
    public ResponseEntity cancelReservation(@PathVariable String reservation_id) {
        reservationRepository.cancelReservation(Integer.valueOf(reservation_id));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/reservation/availableSearch", method = RequestMethod.GET)
    public List<AvailableRoomsType> availableSearch(@RequestParam(value = "checkin", required = true) String checkin,
                                                    @RequestParam(value = "checkout", required = true) String checkout,
                                                    @RequestParam(value = "adults", required = true) int adults,
                                                    @RequestParam(value = "children", required = true) int children) {

            List<AvailableRoomsType> availableRoomsTypes = reservationRepository.searchAvailable(checkin, checkout, adults, children);
            return availableRoomsTypes;

    }

}