import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Zoe", "Alice", "John", "Mark");
        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));
        names.forEach(System.out::println);
    }
}
