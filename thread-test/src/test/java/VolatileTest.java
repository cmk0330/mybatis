import lombok.Synchronized;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    //    public AtomicInteger num = new AtomicInteger();
    public int num;



    /**
     * 可见性测试
     */

    @Test
    public void test2() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("--->" + num);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                num++;
            }
        });
        thread1.start();
        thread2.start();
    }

}
