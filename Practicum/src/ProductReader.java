import javax.swing.JFileChooser;
import java.io.File;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");

                    if (data.length == 4) {
                        String id = data[0].trim();
                        String name = data[1].trim();
                        String description = data[2].trim();
                        double cost = Double.parseDouble(data[3].trim());

                        System.out.println(String.format("%-8s %-15s %-30s $%.2f", id, name, description, cost));
                    } else {
                        System.out.println("Invalid record format: " + line);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
