package ss.week1.hotel;

import ss.utils.TextIO;

import java.util.HashMap;
import java.util.Map;

/*P-1.12*/
public class HotelTUI {
    static final char IN = 'i';
    static final char OUT = 'o';
    static final char ROOM = 'r';
    static final char PRINT = 'p';
    static final char EXIT = 'x';
    static final char HELP = 'h';

//private String person = "Richard";
//private static String hotel = "Hotel U Parkhotel";
//private String room = "Paris";

    private static HashMap<String, String> roomsGuestList = new HashMap<>();

    private static String getFreeRoom() {
        for (Map.Entry<String, String> entry : roomsGuestList.entrySet()) {
            if (entry.getValue().isEmpty()) {
                return entry.getKey();
            }
        }
        System.out.println("No rooms available");
        return null;
    }

    private static String getRoomByName(String name) {
        for (Map.Entry<String, String> entry : roomsGuestList.entrySet()) {
            if (entry.getValue().equals(name)) {
                return entry.getKey();
            }
        }
        System.out.println("Guest does not occupy a room");
        return null;
    }

    private static String getNameByRoom(String room) {
        for (Map.Entry<String, String> entry : roomsGuestList.entrySet()) {
            if (entry.getKey().equals(room)) {
                return entry.getValue();
            }
        }
        System.out.println("Guest does not occupy a room");
        return null;
    }

    private static void printHotelList() {
        for (Map.Entry<String, String> entry : roomsGuestList.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                System.out.println("> Room " + entry.getKey() + ": taken by " + entry.getValue());
            } else {
                System.out.println("> Room " + entry.getKey() + ": empty");
            }
        }
    }

    public static void main(String[] args) {
        /*Occupy rooms*/
        roomsGuestList.put("101", "");

        /*Create the command interface*/

    }
}
