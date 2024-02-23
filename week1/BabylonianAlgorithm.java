package ss.week1;
import ss.utils.TextIO;
/*P-1.9 */
public class BabylonianAlgorithm {
    public static void main(String[] args) {
        double n;
        System.out.println("Please input your number: ");
        n = TextIO.getDouble();

        double guess = n / 2.0;
        double previousGuess = 0.0;

        while (Math.abs(guess-previousGuess) > (0.01*previousGuess)) {
            previousGuess = guess;
            double r = n / guess;
            guess = (guess + r) / 2.0;
            System.out.println(String.format("My guess is that square root of %s is %.2f", n, guess));
        }

    }

}
