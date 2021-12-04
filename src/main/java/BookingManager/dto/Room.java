package BookingManager.dto;

import java.math.BigDecimal;

public class Room {
    private String roomNumber;
    private String guestName;
    private int availableDateFrom;
    private int availableDateTo;
    private int orderDateFrom;
    private int orderDateTo;

    public int getOrderDateFrom() {
        return orderDateFrom;
    }

    public void setOrderDateFrom(int orderedDateFrom) {
        this.orderDateFrom = orderedDateFrom;
    }

    public int getOrderDateTo() {
        return orderDateTo;
    }

    public void setOrderDateTo(int orderedDateTo) {
        this.orderDateTo = orderedDateTo;
    }

    public int getAvailableDateFrom() {
        return availableDateFrom;
    }

    public void setAvailableDateFrom(int availableDateFrom) {
        this.availableDateFrom = availableDateFrom;
    }

    public int getAvailableDateTo() {
        return availableDateTo;
    }

    public void setAvailableDateTo(int availableDateTo) {
        this.availableDateTo = availableDateTo;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


}
