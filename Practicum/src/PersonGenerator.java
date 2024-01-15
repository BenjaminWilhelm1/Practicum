import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> people = new ArrayList<>();
        boolean done = false;

        while (!done) {
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID (a String)");
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter first name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter last name");
            String title = SafeInput.getNonZeroLenString(scanner, "Enter title (a string like Mr., Mrs., Ms., Dr., etc.)");
            int yearOfBirth = SafeInput.getRangedInt(scanner, "Enter year of birth", 0, 2024);

            people.add(id + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth);

            done = !SafeInput.getYNConfirm(scanner, "Do you want to add another person");
        }

        String filename = SafeInput.getNonZeroLenString(scanner, "Enter filename to save");
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (String person : people) {
                writer.println(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
