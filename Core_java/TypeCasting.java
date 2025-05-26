public class TypeCasting {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int myInt = (int) myDouble; // Explicit casting: double to int

        System.out.println("Original double: " + myDouble);
        System.out.println("After casting to int: " + myInt);

        int anotherInt = 15;
        double castedDouble = anotherInt; // Implicit casting: int to double

        System.out.println("Original int: " + anotherInt);
        System.out.println("After casting to double: " + castedDouble);
    }
}
