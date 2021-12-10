import BookingManager.dto.Room;
import BookingManager.logic.SearchByName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchByNameTest {

    // correct input information, one booked room is found
    @DisplayName("Test SearchByName.searchByName1()")
    @Test
    public void searchByName1() {
        SearchByName searchByName = new SearchByName();
        ArrayList<Room> result = searchByName.searchByName("Jeff");
        // room2 is found
        assertTrue(result.size() == 1);
        assertTrue(result.get(0).getOrderDateFrom()==20100114);
        assertTrue(result.get(0).getOrderDateTo()==20100114);
        assertEquals(result.get(0).getGuestName(),"Jeff");
        assertEquals(result.get(0).getRoomNumber(),"1166");
    }

    // correct input information, three booked rooms are found
    @DisplayName("Test SearchByName.searchByName2()")
    @Test
    public void searchByName2() {
        SearchByName searchByName = new SearchByName();
        ArrayList<Room> result = searchByName.searchByName("Sasa");
        System.out.println(result.size());
        assertTrue(result.size() == 3);
        // roo6
        assertTrue(result.get(0).getOrderDateFrom()==20100111);
        assertTrue(result.get(0).getOrderDateTo()==20100111);
        assertEquals(result.get(0).getGuestName(),"Sasa");
        assertEquals(result.get(0).getRoomNumber(),"1111");
        // room7
        assertTrue(result.get(1).getOrderDateFrom()==20100112);
        assertTrue(result.get(1).getOrderDateTo()==20100112);
        assertEquals(result.get(1).getGuestName(),"Sasa");
        assertEquals(result.get(1).getRoomNumber(),"1100");
        // room8
        assertTrue(result.get(2).getOrderDateFrom()==20100113);
        assertTrue(result.get(2).getOrderDateTo()==20100113);
        assertEquals(result.get(2).getGuestName(),"Sasa");
        assertEquals(result.get(2).getRoomNumber(),"11AA");
    }

    // correct input information, one booked room is found
    @DisplayName("Test SearchByName.searchByName3()")
    @Test
    public void searchByName3() {
        SearchByName searchByName = new SearchByName();
        // no guest named Kafa has booked any room
        ArrayList<Room> result = searchByName.searchByName("kafa");
        // no room is found
        assertTrue(result.size() == 0);
    }

    // invalid input name
    @DisplayName("Test SearchByName.searchByName4()")
    @Test
    public void searchByName4() {
        SearchByName searchByName = new SearchByName();
        // guestName is ""
        ArrayList<Room> result = searchByName.searchByName("");
        // no room is found
        assertTrue(result.size() == 0);
    }

    // invalid input name
    @DisplayName("Test SearchByName.searchByName5()")
    @Test
    public void searchByName5() {
        SearchByName searchByName = new SearchByName();
        // guestName is null
        ArrayList<Room> result = searchByName.searchByName(null);
        assertTrue(result.size() == 0);
    }
}
