package ss.week2;

import ss.utils.TextIO;
import ss.week2.ThreeWayLamp;

public class ThreeWayLampTUI {
    /**
     * @invariant lampState != null;
     * @invariant lampState has always the state of one of the enums {OFF, LOW, MEDIUM, HIGH}
     * */
    /*enums*/
    public enum LampState {
        OFF, LOW, MEDIUM, HIGH
    }

    /*attribute to hold the state of the lamp*/
    private ss.week2.ThreeWayLamp.LampState lampState;

    /*getter and setter*/
//    /**
//     * returns current state of the lamp
//     * @requires lampState != null
//     * @ensures getLampstate = lampState*/
//    public ss.week2.ThreeWayLamp.LampState getLampState() {
//        return lampState;
//
//    }


//    /**
//     * sets the state of the lamp to the specified state
//     * @requires lampState != null
//     * @ensures getLampstate = lampState*/
//    public void setLampState(ss.week2.ThreeWayLamp.LampState lampState) {
//        this.lampState = lampState;
//        System.out.println("This lamp's state is set to " + lampState);
//    }

    /*constructor - is it needed? to store the default value at least*/


//    /**Constructs a ThreeWayLamp with the default state set to OFF.
//     * @ensures getLampstate() == Lampstate.OFF;
//     * */
//    private LampState ThreeWayLamp() {
//        this.lampState = ss.week2.ThreeWayLamp.LampState.OFF;
//    }
//    /**Prints the current state of the lamp.
//     * */
//    public void printState() {
//        System.out.println("Current lamp state: " + getLampState());
//    }


//    /**Sets the state of the lamp to the next state in the instance: OFF → LOW → MEDIUM → HIGH → OFF;
//     * @requires lampState != null
//     * @ensures The lamp state is set to the next state in the sequence;
//     * */
//    public void nextState() {
//        /*Store original state for the assertion*/
//        ss.week2.ThreeWayLamp.LampState originalState = lampState;
//        switch (lampState) {
//            case OFF:
//                setLampState(ss.week2.ThreeWayLamp.LampState.LOW);
//                break;
//            case LOW:
//                setLampState(ss.week2.ThreeWayLamp.LampState.MEDIUM);
//            case MEDIUM:
//                setLampState(ss.week2.ThreeWayLamp.LampState.HIGH);
//            case HIGH:
//                setLampState(ss.week2.ThreeWayLamp.LampState.OFF);
//        }
//        /*assertion*/
//        assert originalState == ss.week2.ThreeWayLamp.LampState.OFF && getLampState() == ss.week2.ThreeWayLamp.LampState.LOW ||
//                originalState == ss.week2.ThreeWayLamp.LampState.LOW && getLampState() == ss.week2.ThreeWayLamp.LampState.MEDIUM ||
//                originalState == ss.week2.ThreeWayLamp.LampState.MEDIUM && getLampState() == ss.week2.ThreeWayLamp.LampState.HIGH ||
//                originalState == ss.week2.ThreeWayLamp.LampState.HIGH && getLampState() == ss.week2.ThreeWayLamp.LampState.OFF :
//                "Invalid state transition";
//
//    }


    /*Prints a help menu explaining how the user should interact with the program*/
//    public void printHelp() {
//
//    }

    public static void main(String[] args) {
        ss.week2.ThreeWayLamp lamp = new ThreeWayLamp();
        boolean exit = false;
        while (!exit) {
            System.out.println("Input your lamp state: ");
            String input;
            input = TextIO.getln().toUpperCase();
            switch (input) {
                case "OFF":
                    lamp.setLampState(ThreeWayLamp.LampState.OFF);
                    System.out.println("The state of the lamp is set to " + lamp.getLampState());
                    break;
                case "LOW":
                    lamp.setLampState(ThreeWayLamp.LampState.LOW);
                    System.out.println("The state of the lamp is set to " + lamp.getLampState());
                    break;
                case "MEDIUM":
                    lamp.setLampState(ThreeWayLamp.LampState.MEDIUM);
                    System.out.println("The state of the lamp is set to " + lamp.getLampState());
                    break;
                case "HIGH":
                    lamp.setLampState(ThreeWayLamp.LampState.HIGH);
                    System.out.println("The state of the lamp is set to " + lamp.getLampState());
                    break;
                case "STATE":
                    lamp.printState();
                    break;
                case "NEXT":
                    System.out.println("Current lamp state: " + lamp.getLampState());
                    lamp.nextState();
                    System.out.println("The lamp is set to the next state: " + lamp.getLampState());
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
