package ss.week1;
import ss.utils.TextIO;
public class BabylonianAlgorithmNew {
    public static void main(String[] args) {
        System.out.println("Enter a positive number: ");
        double n = TextIO.getDouble();

        double guess = n / 2.0;
        double lastGuess = 0.0;

        while (Math.abs(guess - lastGuess) > 0.01 * lastGuess) {
            lastGuess = guess;
            guess = (guess + n / guess) / 2.0;
        }

        System.out.println("The square root of " + n + " is approximately: " + String.format("%.2f", guess));
    }
}
