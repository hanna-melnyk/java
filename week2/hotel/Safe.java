package ss.week2.hotel;

public class Safe {

    private boolean isActive;
    private boolean isOpen;

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
        if (this.isActive) {
            this.isOpen = true;
        } else {
            this.isOpen = false;
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
