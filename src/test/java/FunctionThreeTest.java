import BookingManager.dto.Room;
import BookingManager.logic.FunctionThree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionThreeTest {

    // correct input information, one booked room is found
    @DisplayName("Test FunctionThree.searchByName1()")
    @Test
    public void searchByName1() {
        FunctionThree functionThree = new FunctionThree();
        ArrayList<Room> result = functionThree.searchByName("Jeff");
        // room2 is found
        assertTrue(result.size() == 1);
        assertTrue(result.get(0).getOrderDateFrom()==20100115);
        assertTrue(result.get(0).getOrderDateTo()==20100115);
        assertEquals(result.get(0).getGuestName(),"Jeff");
        assertEquals(result.get(0).getRoomNumber(),"1166");
    }

    // correct input information, three booked rooms are found
    @DisplayName("Test FunctionThree.searchByName2()")
    @Test
    public void searchByName2() {
        FunctionThree functionThree = new FunctionThree();
        ArrayList<Room> result = functionThree.searchByName("Sasa");
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
    @DisplayName("Test FunctionThree.searchByName3()")
    @Test
    public void searchByName3() {
        FunctionThree functionThree = new FunctionThree();
        // no guest named Kafa has booked any room
        ArrayList<Room> result = functionThree.searchByName("kafa");
        // no room is found
        assertTrue(result.size() == 0);
    }

    // invalid input name
    @DisplayName("Test FunctionThree.searchByName4()")
    @Test
    public void searchByName4() {
        FunctionThree functionThree = new FunctionThree();
        // guestName is ""
        ArrayList<Room> result = functionThree.searchByName("");
        // no room is found
        assertTrue(result.size() == 0);
    }

    // invalid input name
    @DisplayName("Test FunctionThree.searchByName5()")
    @Test
    public void searchByName5() {
        FunctionThree functionThree = new FunctionThree();
        // guestName is null
        ArrayList<Room> result = functionThree.searchByName(null);
        assertTrue(result.size() == 0);
    }
}
