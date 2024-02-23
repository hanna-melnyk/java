package ss.week1;
import ss.utils.TextIO;


/*P-1.6 (ECK Exercise 2.5)*/
public class GrossAndDozens {
    public static void main(String[] args) {
        System.out.println("How many eggs do you have?");
        int answer = TextIO.getlnInt();
        int answerGross = answer / 144;
        int answerDozen = (answer % 144 ) / 12;
        int answerEggs = answer % 12 ;
        System.out.println("Your number of eggs is " + answerGross + " gross, " + answerDozen + " dozen, and " + answerEggs);
    }
}
