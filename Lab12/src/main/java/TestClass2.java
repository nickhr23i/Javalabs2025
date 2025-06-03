import org.example.Test;

public class TestClass2 {

    public static double y=29.53;

    public void example(int x) {
        x=7;
    }

    @Test
    public void nonStaticTest(String s) {
        System.out.println("Received as input the string: " + s);
    }

    @Test
    public static void testWithParams(int x) {
        System.out.println("Received as input the number: " + x);
    }

    @Test
    public static void test1() {
        throw new RuntimeException("Boom");
    }

    @Test
    public static void test2() {
        System.out.println("Running test2 from TestClass2...");
    }

    public void notATest() {
        System.out.println("TestClass2: This should not run.");
    }
}
