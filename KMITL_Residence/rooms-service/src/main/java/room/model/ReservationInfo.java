package room.model;

/**
 * Created by Adisorn on 26/4/2560.
 */
public class ReservationInfo extends Reservation {

    private String checkInStatus;
    private String checkOutStatus;

    public ReservationInfo(int id, String checkIn, String checkOut,
                           int total, int roomType, String status,
                           Customer customer, String checkInStatus, String checkOutStatus) {
        super(id, checkIn, checkOut, total, roomType, status, customer);
        this.checkInStatus = checkInStatus;
        this.checkOutStatus = checkOutStatus;
    }

    public ReservationInfo() {

    }

    public String getCheckInStatus() {
        return checkInStatus;
    }

    public void setCheckInStatus(String checkInStatus) {
        this.checkInStatus = checkInStatus;
    }

    public String getCheckOutStatus() {
        return checkOutStatus;
    }

    public void setCheckOutStatus(String checkOutStatus) {
        this.checkOutStatus = checkOutStatus;
    }
}
