package BookingManager.logic;

import BookingManager.common.ConfigureRooms;
import BookingManager.common.ErrorMessage;
import BookingManager.dto.Room;

import java.util.ArrayList;

public class SearchByDate {

    public ArrayList<Room> searchByDate(int queryDate){
        ConfigureRooms configureRooms = new ConfigureRooms();
        ArrayList<Room> totalrooms = configureRooms.configureRooms();
        ArrayList<Room> availableRooms = new ArrayList<>();
        if(queryDate==0){
            ErrorMessage errorMessage = ErrorMessage.DATE_ERROR;
            System.out.println("状态码：" + errorMessage.code() +
                    " 状态信息：" + errorMessage.msg());
            return availableRooms;
        }
        if (!totalrooms.isEmpty()){
            for (Room room: totalrooms) {
                if (room.getAvailableDateFrom() <= queryDate &&
                        room.getAvailableDateTo() >= queryDate){
                    availableRooms.add(room);
                }
            }
        }
        return availableRooms;
    }
}
