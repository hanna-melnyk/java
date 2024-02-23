package ss.week1;


public class RollTheDice {




    public static void main(String[]args){
        int diceRollOne = (int) ((Math.random()*6) + 1);
        int diceRollOneTwo = (int) ((Math.random()*6) + 1);
        System.out.println("The first die comes up " + diceRollOne);
        System.out.println("The second die comes up " + diceRollOneTwo);
        System.out.println("Your final result is " + (diceRollOne+diceRollOneTwo));
    }
}
