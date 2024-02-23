package ss.week3.hotel;

public class Safe {


    //since isActive was private, PricedSafe could not access those values
    //I've made isActive protected, so that it could be seen by the class from the same package
    protected boolean isActive;
    protected boolean isOpen;

    /** returns true if the safe is active, false otherwise*/
    public boolean isActive(){
        return this.isActive;
    }

    /**returns true if the safe is open, false otherwise*/
    public boolean isOpen() {
        return this.isOpen;
    }


    public void close() {
        isOpen = false;
    }


public void open() {
    if (this.isActive()) {
        this.isOpen = true;
    }
}

    public boolean activate() {
        this.isActive = true;
        return true;
    }
    public void deactivate() {
        this.isActive = false;
        this.close();
    }



    /*Default constructor*/
    public Safe() {
        this.isOpen = false;
        this.isActive = false;

    }
}
