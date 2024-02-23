package ss.week3.bill;

public class StringPrinter implements Printer {


    private StringBuilder result;

    public StringPrinter() {
        result = new StringBuilder();
    }

    public String getResult() {
        return result.toString();
    }

    @Override
    public void printLine(String text, double price) {
        result.append(this.format(text, price));
    }

    public static void main(String[] args) {

        StringPrinter stringPrinter = new StringPrinter();
        //passed information is appended to the result variable:
        stringPrinter.printLine("Text1", 1.0);
        stringPrinter.printLine("Other text", -12.1212);
        stringPrinter.printLine("Something", 0.2);

        System.out.println(stringPrinter.getResult());
    }
}
