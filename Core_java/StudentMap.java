import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        students.put(101, "Alice");
        students.put(102, "Bob");
        students.put(103, "Charlie");

        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        System.out.println("Name: " + students.getOrDefault(id, "Not found"));
    }
}
