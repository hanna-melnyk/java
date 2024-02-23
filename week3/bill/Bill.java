package ss.week3.bill;

import java.util.ArrayList;

public class Bill {

    double total;
    Printer printer;


    /**interface Item that is nested inside of a Bill*/
    public interface Item {
    double getAmount();

    }

    /**Adds an item to this Bill.
     * @param item - an item to add to the bill
     * @reuires item != null
     * @ensures this.getSum ==  \old(getSum()) + item.getAmount();*/
    public void addItem(Bill.Item item) {
        printer.printLine(item.toString(), item.getAmount());
        this.total += item.getAmount();
    }

    /**Sends the sum total of the bill to the printer.*/
    public void close(){
        printer.printLine("Total ", getSum());
    };

    /**     Returns the current sum total of the Bill.
     * @return the current sum total of the Bill
     * @ensure result >= 0 */
    public double getSum() {
        return total;
    };

    /**Constructor. Constructs a Bill sending the output to a given Printer.
     *@require printer != null
     *@ensure getSum() == 0*/

    // set total to zero?
    public Bill(Printer printer) {
        this.printer = printer;
        this.total = 0;
    }
}
