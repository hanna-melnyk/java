package ss.week3.hotel;

import ss.utils.TextIO;
import ss.week3.bill.Bill;
import ss.week3.bill.SysoutPrinter;
//import ss.week2.hotel.Hotel;
//import ss.week2.hotel.Room;
//import ss.week2.hotel.Safe;

public class HotelTUI {
    private Hotel hotel;
    private static final char PRINT_BILL_COMMAND = 'b';

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
        System.out.println("a name password .. activate safe, password required for PricedSafe");
        System.out.println("b name nights..... print bill for guest (name) and number of nights");
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
                        if (requestedSafe instanceof PricedSafe) {
                            if (split.length >2) {
                                String safePassword = split[2];
                                ((PricedSafe) requestedSafe).activate(safePassword);
                                System.out.println("You have requested to activate safe. Safe active: " + requestedSafe.isActive());
                            } else {
                                System.out.println("Wrong params at activation (password required)");
                            }
                        } else {
                            requestedSafe.activate();
                            System.out.println("You have requested to activate safe. Safe active: " + requestedSafe.isActive());
                        }
                    }
                    break;
                case PRINT_BILL_COMMAND: // char b
                    if (split.length < 3) {
                        System.out.println("Command failed. Please provide command in format 'b name nights' and try again");
                    } else if (hotel.getRoom(parm) == null) {
                        System.out.println("Guest " + parm + " is not checked in");
                    } else {
                        int nights = Integer.parseInt(split[2]); // convert String to Integer
                        SysoutPrinter sysoutPrinter = new SysoutPrinter();
                        Bill newBill = hotel.getBill(parm, nights, sysoutPrinter);
                    }
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

