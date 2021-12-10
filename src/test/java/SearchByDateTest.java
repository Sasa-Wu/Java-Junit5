import BookingManager.dto.Room;
import BookingManager.logic.SearchByDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchByDateTest {

    SearchByDate searchByDate = new SearchByDate();

    // correct input information, one room is found
    @DisplayName("Test searchByDate.searchByDate1()")
    @Test
    public void searchByDate1() {
        ArrayList<Room> result = searchByDate.searchByDate(20100115);
        assertTrue(result.size() == 1);
        assertTrue(result.get(0).getOrderDateFrom()==20100114);
        assertTrue(result.get(0).getOrderDateTo()==20100114);
        assertEquals(result.get(0).getGuestName(),"Jeff");
        assertEquals(result.get(0).getRoomNumber(),"1166");
    }

    // No error in input information, and three rooms are found
    @DisplayName("Test searchByDate.searchByDate2()")
    @Test
    public void searchByDate2() {
        ArrayList<Room> result = searchByDate.searchByDate(20100116);
        // 3 rooms has found, so the list's size is 3
        assertTrue(result.size() == 3);
        // room3
        assertTrue(result.get(0).getAvailableDateFrom()==20100116);
        assertTrue(result.get(0).getAvailableDateTo()==20100116);
        assertEquals(result.get(0).getGuestName(),"Kate");
        assertEquals(result.get(0).getRoomNumber(),"1144");
        // room4
        assertTrue(result.get(1).getAvailableDateFrom()==20100116);
        assertTrue(result.get(1).getAvailableDateTo()==20100116);
        assertEquals(result.get(1).getGuestName(),"May");
        assertEquals(result.get(1).getRoomNumber(),"1133");
        // room5
        assertTrue(result.get(2).getAvailableDateFrom()==20100116);
        assertTrue(result.get(2).getAvailableDateTo()==20100116);
        assertEquals(result.get(2).getGuestName(),"Laura");
        assertEquals(result.get(2).getRoomNumber(),"1122");
    }

    // invalid queryDate is input, then no available room is found
    @DisplayName("Test searchByDate.searchByDate3()")
    @Test
    public void searchByDate3() {
        ArrayList<Room> result = searchByDate.searchByDate(0);
        assertTrue(result.size() == 0);
    }

    // correct input information, no room is found
    @DisplayName("Test searchByDate.searchByDate4()")
    @Test
    public void searchByDate4() {
        // set the query date is 20170115
        ArrayList<Room> result = searchByDate.searchByDate(20170115);
        assertTrue(result.size() == 0);
    }
}
