import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {

    public static void main(String[] args){
        boolean doneInput = false;

        String id = "";
        String name = "";
        String description = "";
        double cost = 0.0;
        String record = "";
        String fileName = "";

        ArrayList<String> products = new ArrayList<>();
        Scanner in = new Scanner(System.in);

            System.out.println("Welcome to the Product Writer!");

        // Collect product data
        do {
            id = SafeInput.getNonZeroLenString(in, "Enter the product ID (e.g., 000001)");
            name = SafeInput.getNonZeroLenString(in, "Enter the product name");
            description = SafeInput.getNonZeroLenString(in, "Enter the product description");
            cost = SafeInput.getDouble(in, "Enter the product cost");

            // Format the record
            record = id + ", " + name + ", " + description + ", " + cost;
            products.add(record);

            System.out.println("Product added: " + record);

            // Check if the user wants to add more products
            doneInput = SafeInput.getYNConfirm(in, "Are you finished?");
            System.out.println("Done input flag: " + doneInput);  // Debugging
        } while (!doneInput);

        // File saving
        fileName = SafeInput.getNonZeroLenString(in, "Enter the desired file name (without extension)") + ".txt";
        Path file = Paths.get(System.getProperty("user.dir") + "\\src\\" + fileName);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
                for (String product : products) {
                    writer.write(product);
                    writer.newLine();
            }
            System.out.println("Data file written successfully to: " + file.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


