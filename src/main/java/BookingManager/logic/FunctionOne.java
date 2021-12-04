package BookingManager.logic;

import BookingManager.common.ConfigureRooms;
import BookingManager.common.ErrorMessage;
import BookingManager.dto.Order;
import BookingManager.dto.Room;

import java.util.ArrayList;

public class FunctionOne {
    private int a = 0;
    public synchronized ArrayList saveOrder(Order order) {

            ConfigureRooms configureRooms = new ConfigureRooms();
            ArrayList<Room> totalrooms = configureRooms.configureRooms();
            ArrayList<Room> orderRoom = new ArrayList<>();
            if (order.getDate() == 0) {
                ErrorMessage errorMessage = ErrorMessage.DATE_ERROR;
                System.out.println("状态码：" + errorMessage.code() +
                        " 状态信息：" + errorMessage.msg());
                return orderRoom;
            }
            if (order.getGuestName() == null || order.getGuestName().equals("")) {
                ErrorMessage errorMessage = ErrorMessage.NAME_ERROR;
                System.out.println("状态码：" + errorMessage.code() +
                        " 状态信息：" + errorMessage.msg());
                return orderRoom;
            }
            if (order.getRoomNumber() == null || order.getRoomNumber().equals("")) {
                ErrorMessage errorMessage = ErrorMessage.NUMBER_ERROR;
                System.out.println("状态码：" + errorMessage.code() +
                        " 状态信息：" + errorMessage.msg());
                return orderRoom;
            }
            if (!totalrooms.isEmpty()) {
                try {
                    Thread.sleep(100);
                    System.out.println("The hotel staff is helping " + Thread.currentThread().getName() + " checking the room"
                            );
                } catch (InterruptedException ie) {

                }
                for (Room room : totalrooms) {
                    if (order.getRoomNumber().equals(room.getRoomNumber()) &&
                            room.getAvailableDateFrom() <= order.getDate() &&
                            room.getAvailableDateTo() >= order.getDate() &&
                            room.getGuestName() == null && a ==0) {
                        room.setGuestName(order.getGuestName());
                        room.setOrderDateFrom(order.getDate());
                        room.setOrderDateTo(order.getDate());
                        orderRoom.add(room);
                        System.out.println("The room has been booked by " + Thread.currentThread().getName());
                        a += 1;
                        break;
                    }
                }
            }
            return orderRoom;
        }
    }


