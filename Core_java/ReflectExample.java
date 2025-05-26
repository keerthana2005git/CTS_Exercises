import java.lang.reflect.*;

public class ReflectExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        Method[] methods = clazz.getDeclaredMethods();

        for (Method m : methods) {
            System.out.println(m.getName() + " returns " + m.getReturnType());
        }
    }
}
