package BookingManager.logic;

import BookingManager.common.ConfigureRooms;
import BookingManager.common.ErrorMessage;
import BookingManager.dto.Room;

import java.util.ArrayList;

public class FunctionThree {

    public ArrayList<Room> searchByName(String guestName){
        ConfigureRooms configureRooms = new ConfigureRooms();
        ArrayList<Room> totalrooms = configureRooms.configureRooms();
        ArrayList<Room> orderedRooms = new ArrayList<>();
        if (guestName == null || guestName.equals("")){
            ErrorMessage errorMessage = ErrorMessage.NAME_ERROR;
            System.out.println("状态码：" + errorMessage.code() +
                    " 状态信息：" + errorMessage.msg());
            return orderedRooms;
        }
        if(!totalrooms.isEmpty()){
            for (Room room: totalrooms) {
                if (room.getGuestName()!=null && room.getGuestName().equals(guestName)){
                    System.out.println(room.getGuestName());
                    orderedRooms.add(room);
                }
            }
        }
        return orderedRooms;
    }
}
