import java.util.Arrays;
import java.util.List;

record Person(String name, int age) {}

public class Record {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 22),
            new Person("Bob", 17),
            new Person("Charlie", 19)
        );
        people.stream().filter(p -> p.age() >= 18).forEach(System.out::println);
    }
}
