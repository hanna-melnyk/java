package ss.week1.hotel;

/*P-1.11 */
public class SimpleBillPrinter {
    public static String description = "Hotel night 1x";
    public static double price = 85.50;
    public static String bill = String.format("%-25s %8.2f", description, price);

    public static void main(String[] args) {
        System.out.println(bill);
    }

}
