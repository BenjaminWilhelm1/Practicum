import javax.swing.JFileChooser;
import java.io.File;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");

                    if (data.length == 5) {
                        String id = data[0].trim();
                        String firstName = data[1].trim();
                        String lastName = data[2].trim();
                        String title = data[3].trim();
                        int yearOfBirth = Integer.parseInt(data[4].trim()); //I assume this is the correct format for bday

                        System.out.println(String.format("%-8s %-12s %-12s %-10s %-4d", id, firstName, lastName, title, yearOfBirth));
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
