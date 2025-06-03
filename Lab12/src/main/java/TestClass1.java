import org.example.Test;

public class TestClass1 {

    private int x = 7;

    public void example(int x) {
        x = 7;
    }

    @Test
    public void nonStaticTest() {
        throw new RuntimeException("Boom");
    }

    @Test
    public static void testWithParams(int x) {
        System.out.println("Success");
    }

    @Test
    public static void test1() {
        System.out.println("Running test1 from TestClass1...");
    }

    @Test
    public static void test2() {
        throw new RuntimeException("Boom");
    }

    public void notATest() {
        System.out.println("TestClass1: This should not run.");
    }
}
