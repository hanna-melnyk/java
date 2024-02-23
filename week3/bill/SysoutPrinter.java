package ss.week3.bill;

public class SysoutPrinter implements Printer {
    @Override
    public void printLine(String text, double price) {
        System.out.println(this.format(text, price));
    }

    public static void main(String[] args) {
        SysoutPrinter sysoutPrinter = new SysoutPrinter();
        sysoutPrinter.printLine("Text1", 1.0);
        sysoutPrinter.printLine("Other text", -12.1212);
        sysoutPrinter.printLine("Something", .2);
    }



}
