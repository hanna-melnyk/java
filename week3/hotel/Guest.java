package ss.week3.hotel;

//imported Guest from week 2


/**@author Hanna Melnyk*/
public class Guest {


    private String name;
    private Room room;



    /** Returns a String representation of a guest*/
    @Override
    public String toString() {
        return "Guest " + this.getName();
    }



    /**Constructs a new guest with a given name
     * @param name of the guest*/



    public Guest(String name) {
        this.name = name;
    }


    /**Returns the name of the guest
     * @return name of the guest*/
    public String getName() {
        return this.name;
    }

    /**
     * @return room of the guest*/
    public Room getRoom() {
        return this.room;
    }


    /** Checks the guest into a room
     * @param room number
     * @requires the room chosen for check-in is not occupied
     * @return true if check-in is successful, false otherwise
     * (if the room is already taken, etc)*/
    public boolean checkin(Room room){
        if (room.getGuest() == null && this.room == null) {
            room.setGuest(this);
            this.room = room;
            return true;
        }
        return false;
    }

    /**Checks the guest out from the room
     * @requires the guest is checked into a room
     * @return true if check-out is successful, false otherwise */
    public boolean checkout() {
        if (this.room != null) {
            this.room.setGuest(null);
            this.room = null;
            return true;
        }
        return false;
    }



}
