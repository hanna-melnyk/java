package ss.week3.test;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;



import ss.week3.bill.Bill;
import ss.week3.bill.StringPrinter;

import static org.junit.jupiter.api.Assertions.*;

public class BillTest {
private Bill bill;
private StringPrinter printer;

    public class TestItem implements Bill.Item{
        // create a constructor (description, price)
        // protected String description, protected double price
        private String text;
        private double amount;
        /** Constructor*/
        public TestItem(String text, double amount) {
            this.text = text;
            this.amount = amount;
        }
        //
        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return text;
        }
    }

@BeforeEach
public void setUp() {
    this.printer = new StringPrinter();
    this.bill = new Bill(printer);
}

@Test
public void testBeginState() {
    this.printer = new StringPrinter();
    this.bill = new Bill(printer);
    assertEquals(0, bill.getSum(), 0.0005);
}

@Test
public void testNewItem() {
    this.printer = new StringPrinter();
    this.bill = new Bill(printer);
    Bill.Item item1 = new TestItem("Item1", 10);
    Bill.Item item2 = new TestItem("Item2", 15);
    bill.addItem(item1);
    bill.addItem(item2);
    bill.close();
    assertEquals(25, bill.getSum(), 0.0005);
}



}
