package ss.week1;

import ss.utils.TextIO;

/*P-1.7 (ECK Exercise 3.2)*/

public class MostDivisors {
    public static void main(String[] args) {
    int n;
    int testDivisor; /*divisor*/
    int divisorCount; /*amount of divisors that the number n has*/
    int maxDivisorCount;
    int numberWMaxDivisors;

    maxDivisorCount = 0;
    numberWMaxDivisors = 0;

        for (n = 1; n <= 10000; n++) {
            divisorCount = 0;
            for (testDivisor = 1; testDivisor <= n; testDivisor++) {
                if (n % testDivisor == 0)
                    divisorCount++;

            }
            if (divisorCount > maxDivisorCount) {
                maxDivisorCount = divisorCount;
                numberWMaxDivisors = n;
            }

        }
        System.out.println("Number that has the largest number of divisors: " + numberWMaxDivisors);
        System.out.println("Number has "+ maxDivisorCount + " divisors");

    }
}
