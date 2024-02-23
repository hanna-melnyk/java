package ss.week1;
import ss.utils.TextIO;

public class ThreeWayLamp {

    /*enums*/
    public enum LampState {
        OFF, LOW, MEDIUM, HIGH
    }

    /*attribute to hold the state of the lamp*/
    private LampState lampState;

    /*getter and setter*/

    public LampState getLampState() {
        return lampState;

    }



    public void setLampState(LampState lampState) {

        this.lampState = lampState;
        System.out.println("This lamp's state is set to " + lampState);
    }

    /*constructor - is it needed? to store the default value at least*/



    private ThreeWayLamp() {
        this.lampState = LampState.OFF;
    }

    public void printState() {
        System.out.println("Current lamp state: " + getLampState());
    }



    public void nextState() {
        /*Store original state for the assertion*/

        switch (lampState) {
            case OFF:
                setLampState(LampState.LOW);
            case LOW:
                setLampState(LampState.MEDIUM);
            case MEDIUM:
                setLampState(LampState.HIGH);
            case HIGH:
                setLampState(LampState.OFF);
        }


    }


    /*Prints a help menu explaining how the user should interact with the program*/
    public void printHelp() {
        System.out.println("******You have entered a help menu****** \nUser instructions:\n");
        System.out.println("OFF: Set the lamp to OFF");
        System.out.println("LOW: Set the lamp to LOW");
        System.out.println("MEDIUM: Set the lamp to MEDIUM");
        System.out.println("HIGH: Set the lamp to HIGH");
        System.out.println("STATE: Print the current setting of the lamp");
        System.out.println("NEXT: Change to the next setting, observing the order OFF → LOW → MEDIUM → HIGH → OFF");
        System.out.println("HELP: Show a help menu, explaining how the user should interact with the program");
        System.out.println("EXIT: Quit the program");
    }

    public static void main(String[] args) {
        ThreeWayLamp lamp = new ThreeWayLamp();
        boolean exit = false;
        while (!exit) {
            System.out.println("Input your lamp state: ");
            String input;
            input = TextIO.getln().toUpperCase();
            switch (input) {
                case "OFF":
                    lamp.setLampState(LampState.OFF);
                    break;
                case "LOW":
                    lamp.setLampState(LampState.LOW);
                    break;
                case "MEDIUM":
                    lamp.setLampState(LampState.MEDIUM);
                    break;
                case "HIGH":
                    lamp.setLampState(LampState.HIGH);
                    break;
                case "STATE":
                    lamp.printState();
                    break;
                case "NEXT":
                    lamp.nextState();
                    break;
                case "HELP":
                    lamp.printHelp();
                    break;
                case "EXIT":
                    System.out.println("You have exited the program");
                    exit = true;
                    break;
                default:
                    System.out.println("The input is not valid. Try again");
            }
        }
    }
}
