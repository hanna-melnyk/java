package ss.week2.hotel;

import ss.utils.TextIO;

public class HotelTUI {
    private Hotel hotel;



    /**
     * Constructor for HotelTUI with the name of the hotel as an argument.
     *
     * @param hotelName The name of the hotel.
     */
    public HotelTUI(String hotelName) {
        this.hotel = new Hotel(hotelName);
    }

    /**
     * Prints the help menu with available commands.
     */
    public void printHelpMenu() {
        System.out.println(String.format("Welcome to the Hotel booking system of the %s", hotel.getHotelName()));
        System.out.println("Commands:");
        System.out.println("i name ........... check in guest with name");
        System.out.println("o name ........... check out guest with name");
        System.out.println("r name ........... request room of guest");
        System.out.println("a name ........... activate safe");
        System.out.println("h ................ help (this menu)");
        System.out.println("p ................ print state");
        System.out.println("x ................ exit");
    }


    /**
     * Prints the current state of the hotel.
     */
    public void printState() {
        System.out.println(hotel.toString());
    }

    /**
     * Starts the hotel text-based user interface.
     */
    public void start() {
        boolean exit = false;
        while (!exit) {
            //System.out.println("Your command:");
            String input;
            input = TextIO.getln();
            String[] split = input.split(" ");
            char command = split[0].charAt(0);
            String parm = null;
            if (split.length > 1) {
                parm = split[1];
            }

            switch (command) {
                case 'i':
                    if (parm == null) {
                        System.out.println("Check-in failed. Please provide guest name and try again");
                    }
                    hotel.checkIn(parm);
                    System.out.println("Guest " + parm + " has checked into a room " + hotel.getRoom(parm));
                    if (hotel.getRoom(parm) == null) {
                        System.out.println("Check-in failed");
                    }
                    break;
                case 'o':
                    hotel.checkOut(parm);
                    System.out.println("Guest " + parm + " successfully checked out.");
                    if (hotel.getRoom(parm) != null) {
                        System.out.println("Check-out failed");
                    }
                    break;
                case 'r':
                    Room requestedRoom = hotel.getRoom(parm);
                    if (requestedRoom != null) {
                        System.out.println("Guest " + parm + " has room " + requestedRoom.getNumber());
                    } else {
                        System.out.println("Guest " + parm + " not found or not checked in");
                    }
                    break;
                case 'a':
                    if (hotel.getRoom(parm) == null) {
                        System.out.println("Guest " + parm + " is not checked in");
                    } else {
                    Safe requestedSafe = hotel.getRoom(parm).getSafe();
                    requestedSafe.activate();
                    System.out.println("You have requested to active safe. Safe active: " + requestedSafe.isActive());
                    }
                    break;
                case 'h':
                    printHelpMenu();
                    break;
                case 'p':
                    printState();
                    break;
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("Error. Command is not recognized. \nPlease rewrite your command:");
                    break;
            }
        }
    }


    public static void main(String[] args) {
        new HotelTUI("U Parkhotel").start();
    }


}

