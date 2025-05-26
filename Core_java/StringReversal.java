import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        int left = 0, right = str.length - 1;

        while (left < right) {
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }

        System.out.println("Reversed string: " + new String(str));
    }
}
