package ss.week3.hotel;

import ss.week3.hotel.Guest;
//import ss.week2.hotel.Guest;
import ss.week3.hotel.Room;
import ss.week3.hotel.Safe;
import ss.week3.bill.*;

public class Hotel {
    public static final double ROOM_PRICE = 100;
    public static final double SAFE_PRICE = 1;
    private String name;

    //update the class?
    private Room room2;
    private PricedRoom room1;

    Printer printer;





// parameters in the constructor
    public Hotel(String name) {
        this.name = name;
        room2 = new Room(101);
        //PricedSafe pricedSafe = new PricedSafe(1);
        room1 = new PricedRoom(102,ROOM_PRICE, new PricedSafe(SAFE_PRICE));
    }


    /**
     * @return The name of the hotel.
     */
    public String getHotelName() {
        return this.name;
    }

    /**
     * @return The first available free room or null if no rooms are available.
     */
    public Room getFreeRoom() {
        if (this.room1.getGuest() == null) {
            return this.room1;
        } else if (this.room2.getGuest() == null) {
            return this.room2;
        }
        return null;
    }


    /**
     * @param name name of the guest
     * @requires room.getGuest() != null
     * @return Room - room into which guest has checked in, or null if guest is not found in any room*/
    public Room getRoom(String name) {
        if (this.room1.getGuest() != null && this.room1.getGuest().getName().equals(name)) {
            return this.room1;
        } else if (this.room2.getGuest() != null && this.room2.getGuest().getName().equals(name)) {
            return this.room2;
        }
        return null;
    }



    /**
     * @param name The name of the guest of type String.
     * @requires getRoom(guestName) == null && getFreeRoom() != null
     * @return The room where the new guest has checked in, or null if the specified guest is already checked in or no rooms are available.
     */
    //check if getFreeRoom is connected
    public Room checkIn(String name) {
        if (this.getRoom(name) != null || this.getFreeRoom() == null) {
            return null;
        } else if (this.getFreeRoom() != null) {
            Room freeRoom = this.getFreeRoom();
            Guest newGuest = new Guest(name);
            freeRoom.setGuest(newGuest);
            return freeRoom;
        }
        return null;
    }


    /**
     * @param name The name of the guest to check out.
     * @requires getRoom(guestName) != null
     * @ensures The guest is checked out, and the safe in the room is deactivated.
     */
    public void checkOut(String name) {
        assert name != null: "Guest name is non existent";
        Room assignedRoom = this.getRoom(name);
        if (assignedRoom != null)     {
            assignedRoom.getGuest().checkout();

            Safe assignedSafe = assignedRoom.getSafe();
            assignedSafe.deactivate();
            assignedRoom.setGuest(null);
        }
    }






    /**
     * @requires room.getSafe() != null
     * @returns description of the rooms: room number, guest name, safe status*/
    @Override
    public String toString() {
        String roomsInfo = "";
        String room1Guest = "";
        String room2Guest = "";
        if (room1.getGuest() == null) {
            room1Guest = "empty";
        } else {
            room1Guest = "Guest: " + room1.getGuest().getName();
        }
        if (room2.getGuest() == null) {
            room2Guest = "empty";
        } else {
            room2Guest = "Guest: " + room2.getGuest().getName();
        }
        String roomsInfo1 = room1 + ": " + "\n" + room1Guest + "\n safe active: " + room1.getSafe().isActive();
        String roomsInfo2 = room2 + ": " + "\n" + room2Guest + "\n safe active: " + room2.getSafe().isActive();
        return roomsInfo1 + "\n" + roomsInfo2;
    }


    /**@return a bill if guest stays in PricedRoom
     * @return null if guest stays in regular Room, or guest == null
     * @param guestName name of a guest,
     * @param nights the number of nights the guest spent in the hotel
     * */
    public Bill getBill(String guestName, int nights, Printer printer) {
        assert getRoom(guestName) != null : "Error: guest has not checked in";
        Bill bill = null;
        if (getRoom(guestName) == null) {
            return null;
        }
        Room selectedRoom = getRoom(guestName);
        if (selectedRoom instanceof PricedRoom) {
            bill = new Bill(printer);
            for (int i = 0; i < nights; i++) {
                bill.addItem((PricedRoom) selectedRoom);
            }
        }
        if (selectedRoom.getSafe() instanceof PricedSafe) {
            bill.addItem((PricedSafe) selectedRoom.getSafe());
        }
        bill.close();
        return bill;
    }


}
