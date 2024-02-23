package ss.week2;

import ss.utils.TextIO;

public class ThreeWayLamp {
    /**
     * @invariant lampState != null;
     * @invariant lampState has always the state of one of the enums {OFF, LOW, MEDIUM, HIGH}
     * */
public enum LampState{
        OFF, LOW, MEDIUM, HIGH
}
/**********************************/

private LampState lampState;



    /**
    * sets the state of the lamp to the specified state
    * @requires lampState != null
    * @ensures The lamp state after the method execution is equal to the lampState specified in setLampState(), (meaning getLampState == setLampState()). */
    public void setLampState(LampState lampState){
        this.lampState = lampState;
    }


    /**
     * returns current state of the lamp
     * @requires lampState != null
     * @ensures getLampstate = lampState*/
    public LampState getLampState(){
        return lampState;
    }

    /*changed access from private to public*/
    /**Constructs a ThreeWayLamp with the default state set to OFF.
     * @ensures getLampstate() = Lampstate.OFF;
     * */
    public ThreeWayLamp() {
        this.lampState = LampState.OFF;
    }
    /**Prints the current state of the lamp.
     * */
    public void printState() {
        System.out.println("Current lamp state: " + getLampState());
    }
    /**Sets the state of the lamp to the next state in the instance: OFF → LOW → MEDIUM → HIGH → OFF;
     * @requires lampState != null
     * @ensures The lamp state is set to the next state in the sequence;
     * */

    /*nextState() doesn't work properly without break after each case*/
    public void nextState() {
        /*assertion*/

        LampState originalState = lampState;
        assert originalState == ThreeWayLamp.LampState.OFF && getLampState() == ThreeWayLamp.LampState.LOW ||
                originalState == ThreeWayLamp.LampState.LOW && getLampState() == ThreeWayLamp.LampState.MEDIUM ||
                originalState == ThreeWayLamp.LampState.MEDIUM && getLampState() == ThreeWayLamp.LampState.HIGH ||
                originalState == ThreeWayLamp.LampState.HIGH && getLampState() == ThreeWayLamp.LampState.OFF :
                "Invalid state transition";
        switch (lampState) {
            case OFF:
                setLampState(ThreeWayLamp.LampState.LOW);
                break;
            case LOW:
                setLampState(ThreeWayLamp.LampState.MEDIUM);
                break;
            case MEDIUM:
                setLampState(ThreeWayLamp.LampState.HIGH);
                break;
            case HIGH:
                setLampState(ThreeWayLamp.LampState.OFF);
                break;
        }
    }

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

/**********************************/
/*is constructor also needed in stub implementation?*/

    /* Stub implementation:

    Typically:
    leave the variables as they are
• if the return type is int, use return 0;
• if the return type is boolean, use return false; and
• if the return type is the name of a class, use return null.
- a method with a void return type should be empty.*/

public static void main(String[] args) {

}



}