import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterDemo {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in); FileWriter writer = new FileWriter("output.txt")) {
            System.out.print("Enter text: ");
            writer.write(sc.nextLine());
            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("File write error: " + e.getMessage());
        }
    }
}

