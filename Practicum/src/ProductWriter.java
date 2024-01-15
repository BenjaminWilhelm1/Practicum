import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        boolean done = false;

        while (!done) {
            String id = SafeInput.getNonZeroLenString(scanner, "Enter Product ID ( a string like before)");
            String name = SafeInput.getNonZeroLenString(scanner, "Enter Product Name ( a String)");
            String description = SafeInput.getNonZeroLenString(scanner, "Enter Product Description ( a String a short sentence)");
            double cost = SafeInput.getDouble(scanner, "Enter Product Cost ( This is currency so it will be a Java Double) ");

            products.add(id + ", " + name + ", " + description + ", " + cost);

            done = !SafeInput.getYNConfirm(scanner, "Do you want to add another product");
        }

        String filename = SafeInput.getNonZeroLenString(scanner, "Enter filename to save");
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (String product : products) {
                writer.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
