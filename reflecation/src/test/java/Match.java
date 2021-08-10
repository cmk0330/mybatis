import com.cmk.User;
import org.junit.Test;

public class Match {
    private static int initCount = 666;
    private static User user = new User();


    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    @Test
    public void test() {
        int compute = compute();
//        System.out.println(compute);

        String name = Thread.currentThread().getName();
        System.out.println("主线程--》" + name);

        Thread thread = new Thread(() -> {
            String name1 = Thread.currentThread().getName();
            System.out.println("新线程--》" + name1);
        });
        thread.start();
    }
}
