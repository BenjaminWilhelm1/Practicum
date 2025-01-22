import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> people = new ArrayList<>();
        System.out.println("Welcome to the Person Generator!");
        String id;
        String firstName;
        String lastName;
        String title;
        int yearOfBirth;
        String record;
        boolean going = true;

        //Loop for collecting data from multiple people
        while(going) {
            System.out.println("Enter the following details for a person you would like to enter:");
            // User inputs data
            id = SafeInput.getNonZeroLenString(in, "Enter the person's ID (e.g., 000001)");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the person's first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the person's last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the person's title (e.g., Mr., Mrs., Dr., etc.)");
            yearOfBirth = SafeInput.getRangedInt(in, "Enter the person's birth year", 1000,9999);

            // Create a CSV-formatted record
            record = id + ", " + firstName + ", " + lastName + ", " + title + ", "+ yearOfBirth;
            people.add(record);

            // User input if they are done
            going = SafeInput.getYNConfirm(in, "Do you want add another person?");
        }

        // File name

        String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name to save the data") + ".txt";
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + fileName);

        // Write data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (String person : people) {
                writer.write(person); // Write the record
                writer.newLine(); // Adds a new line after each record
            }
            System.out.println("Data successfully written to " + fileName);

        } catch (IOException e){
            System.out.println("Error writing to file: " + e.getMessage());
        }



    }
}