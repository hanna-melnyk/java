package ss.week3.hotel;

import ss.week3.bill.Bill;

public class PricedRoom extends Room implements Bill.Item {

    double roomPrice;
    //double safePrice;

    /**Constructor
     * creates a new PricedSafe object and passes it to the parent constructor (Room)
     * result of toString includes the price per night.
     * @param  number - room number,
     * @param roomPrice - room price,
     * @param safe -  safe object of the room*/
    public PricedRoom(int number, double roomPrice, Safe safe) {
        super(number, safe);
        this.roomPrice = roomPrice;
    }

    public PricedRoom(int number, double roomPrice, double safePrice) {
        this(number, roomPrice, new PricedSafe(safePrice));
        this.roomPrice = roomPrice;

    }



    @Override
    public String toString() {
        //"Priced safe. Price: %8.2f"
        return String.format("Room %s (%8.2f/night)", getNumber(), roomPrice);
    }
    //Class 'PricedRoom' must either be declared abstract or implement abstract method 'getAmount()' in 'Item'
    @Override
    public double getAmount() {
        return roomPrice;
    }
}
