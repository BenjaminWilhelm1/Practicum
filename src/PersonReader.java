import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class PersonReader {

    public static void main(String[] args){
        JFileChooser fileChooser = new JFileChooser();
        int returnValue;
        File selectedFile;

        // User input to select a file
        returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            selectedFile = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))){
                //Print the table header
                System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", "ID", "First Name", "Last Name", "Title", "YOB");
                System.out.println("===============================================");

                String line;

                //Read file line by line
                while ((line = reader.readLine()) != null) {
                    //Help Debug. Print the raw line being read
                    System.out.println("Reading line: " + line);

                    //Skip each line
                    if (line.trim().isEmpty()) {
                        System.out.println("Skipping empty line.");
                        continue;
                    }

                    // Split the line into parts
                    String[] parts = line.split(",\\s*");
                    if (parts.length != 5) {
                        System.out.println("Skipping malformed line: " + line);
                        continue; // Skip lines that do not have exactly 5 parts
                    }

                    // Print the formatted table row
                    System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", parts[0], parts[1], parts[2], parts[3], parts[4]);

                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

        } else {
            System.out.println("No file selected.");
        }

    }
}
