package room.model;

/**
 * Created by Adisorn on 16/3/2560.
 */
public class Reservation {

    private int id;
    private String checkIn;
    private String checkOut;
    private int total;
    private int roomType;
    private String status;
    private Customer customer;

    public Reservation(int id, String checkIn, String checkOut, int total, int roomType, String status, Customer customer) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.total = total;
        this.roomType = roomType;
        this.status = status;
        this.customer = customer;
    }

    public Reservation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
