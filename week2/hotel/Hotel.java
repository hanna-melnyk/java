package ss.week2.hotel;

public class Hotel {
    private String name;

    private Room room1;
    private Room room2;






    public Hotel(String name) {
        this.name = name;
        room1 = new Room(101);
        room2 = new Room(102);
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
        String roomsInfo1 = room1 + ": " + room1Guest + "\n safe active: " + room1.getSafe().isActive();
        String roomsInfo2 = room2 + ": " + room2Guest + ",\n safe active: " + room2.getSafe().isActive();
        return roomsInfo1 + "\n" + roomsInfo2;
    }



}
