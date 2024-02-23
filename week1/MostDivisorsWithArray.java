package ss.week1;


/*P-1.8 (ECK Exercise 3.6)*/
public class MostDivisorsWithArray {
    public static void main(String[] args) {
        int n;
        int testDivisor; /*divisor*/
        int divisorCount; /*amount of divisors that the number n has*/
        int maxDivisorCount;
        int numberWMaxDivisors;
        int[] maxDivisorsArray = new int[10000];

        maxDivisorCount = 0;
        numberWMaxDivisors = 0;


        for (n = 1; n <= 10000; n++) {
            divisorCount = 0;
            for (testDivisor = 1; testDivisor <= n; testDivisor++) {
                if (n % testDivisor == 0)
                    divisorCount++;

            }
            maxDivisorsArray[n-1] = divisorCount;
            if (divisorCount > maxDivisorCount) {
                maxDivisorCount = divisorCount;
            }
        }

        System.out.println("Among integers between 1 and 10000,");
        System.out.println("The maximum number of divisors was " +maxDivisorCount);
        System.out.println("Numbers with that many divisors include:");
        for (int i = 0; i < maxDivisorsArray.length; i++) {
            if (maxDivisorsArray[i] == maxDivisorCount) {
                System.out.println(i+1);
            }
        }


    }
}
