package ss.week3.hotel;

import ss.week3.bill.Bill;
import ss.week3.password.BasicChecker;
import ss.week3.password.Checker;
import ss.week3.password.Password;

public class PricedSafe extends Safe implements Bill.Item{

    private double price;
    private Password password;
    //private boolean isActive;
    //private boolean isOpen;


    /**Constructor
     * PricedSafe should be password-protected, so that the safe only opens if a valid password is entered.
     * Each PricedSafe can be (de)activated.
     * @param price price of the safe*/
    public PricedSafe(double price) {
        this.price = price;
        this.isActive = false;
        Checker basicChecker = new BasicChecker();
        this.password = new Password(basicChecker);
    }

    //Class 'PricedSafe' must either be declared abstract or implement abstract method 'getAmount()' in 'Item'
    /**@return the amount >> price of Safe. in Bill.java: price of the item. */
    @Override
    public double getAmount() {
        return price;
    }


    /**Overrides the parent method, gives a warning and does not activate
     the safe*/
    @Override
    public boolean activate() {
        System.out.println("Error: Please provide password. Safe is not activated");
        return false;
    }


    /**Activates the safe if the password is correct
     * @param password
     * */
    public boolean activate(String password) {
        if (this.password.testWord(password)) {
            this.isActive = true;
            return true;
        }
        return false;

    }


    /**closes the safe and deactivates it*/
    @Override
    public void deactivate() {
        super.close();
        isActive = false;
    }

    /**Opens the safe if it is active, and the password is correct
     * @require safe,isActive() && this.password.testWord(password)
     * @param password =  String with a password text as a parameter, */
    public void open(String password) {
//        assert this.isActive(): "Error: safe must be active. Please activate the safe";
//        assert this.password.testWord(password): "Error: incorrect password";
        if(this.isActive() && this.password.testWord(password)) {
            this.isOpen = true;
        }
    }


    /** Overrides the parent method and does not change the state of the safe*/
    @Override
    public void open() {
        System.out.println("Error: Please provide password. Safe is not activated");
    }


    /**closes the safe (but does not change its activation status)*/
    public void close() {
        this.isOpen = false;
    }


    public Password getPassword() {
        return password;
    }



    @Override
    public String toString() {
        return String.format("Priced safe. Price: %8.2f", price);
    }

//    public static void main(String[] args) {
////        PricedSafe newPricedSafe = new PricedSafe(6);
////        newPricedSafe.open();
//
//    }
}
