package ss.week2;

public class DollarsAndCentsCounter {

    private int dollars;
    private int cents;

    private int dollarsTotal;

    private DollarsAndCentsCounter dollarsAndCentsCounter;


    public DollarsAndCentsCounter() {
        this.dollars = dollarsTotal;
        this.cents = cents;
    }

    /**@ensures a return value that is bigger or equal to 0*/
    public int dollars() {
        return dollarsTotal;
    }


    /**@ensures a return value in the range of 0 to 99*/
    public int cents() {
        return cents;
    }

/**Adds the speciﬁed dollars and cents to this Counter.*/
    public void add(int dollars, int cents) {
        this.dollarsTotal += dollars;
        this.cents += cents;

        if (this.cents > 99) {
            this.dollarsTotal += (this.cents / 100);
            this.cents =  this.cents % 100;
        }
    }

/** Reset this Counter to 0.
 * @ensures this Counter is set to 0 dollars and 0 cents
 */

    public void reset() {
        dollarsTotal = 0;
        cents = 0;
    }


}
