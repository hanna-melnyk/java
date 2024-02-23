package ss.week2.test;
import ss.week2.ThreeWayLamp;
public class ThreeWayLampTest {
    /*Your class should test
the following cases:
• If after being created the lamp is OFF;
• If the sequence OFF → LOW → MEDIUM → HIGH → OFF is properly implemented.
The ThreeWayLampTest class should have the following elements:

• A (private) variable of type ThreeWayLamp to hold an object to be tested.
• A setUp method that creates the ThreeWayLamp object to be tested.
• A method for each of the two test cases above;
• A runTest method that calls setUp and the methods of the test cases.

The main method of the ThreeWayLampTest class should create a ThreeWayLampTest object and call its
runTest method.*/
    private ThreeWayLamp lamp;
    public void setUp() {
        lamp = new ThreeWayLamp();
    }

    public void testInitialState() {
        assert lamp.getLampState() == ThreeWayLamp.LampState.OFF: "Initial state should be 'OFF'";
    }
    public void testStateTransition() {
        lamp.nextState(); // OFF to LOW
        assert lamp.getLampState() == ThreeWayLamp.LampState.LOW: "State transition failed";
        lamp.nextState(); // LOW to MEDIUM
        assert lamp.getLampState() == ThreeWayLamp.LampState.MEDIUM: "State transition failed";
        lamp.nextState(); // MEDIUM to HIGH
        assert lamp.getLampState() == ThreeWayLamp.LampState.HIGH: "State transition failed";
        lamp.nextState(); // HIGH to OFF
        assert lamp.getLampState() == ThreeWayLamp.LampState.OFF: "State transition failed";

    }

    public void runTest() {
        setUp();
        testInitialState();
        testStateTransition();
    }

    public static void main(String[] args) {
        ThreeWayLampTest test = new ThreeWayLampTest();
        test.runTest();
    }

}
