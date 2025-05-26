public class Simple {
    public int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        Simple s = new Simple();
        System.out.println("Square of 5: " + s.square(5));
    }
}

