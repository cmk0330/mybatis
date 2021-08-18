import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private static int num;
    private static boolean flag = false;
    private static String SSSSSS = ";;;;";

    public static void main(String[] args) {
//        visibility();
        lockTest();

    }

    /**
     * 原子性测试
     */
    public static void atom() {

        ReentrantLock reentrantLock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
//                num.incrementAndGet();
                synchronized (ThreadTest.class) {
                    num++;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
//                num.incrementAndGet();
                synchronized (ThreadTest.class) {
                    num++;
                }
            }
        });
        long startTime = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("--->" + num);
        System.out.println("time-->" + (endTime - startTime));
    }

    /**
     * 可见性
     */
    private static void visibility() {

        Thread thread1 = new Thread(() -> {
            for (; ; ) {
                if (20 == num) {
                    System.out.println(Thread.currentThread().getName() + "--->");
                }
            }
//            while (num == 20) {
//                System.out.println(Thread.currentThread().getName() + "--->" );
//            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                num++;
                System.out.println(Thread.currentThread().getName() + "--->" + num);
            }
        });

        thread1.setName("t1");
        thread2.setName("t2");
        thread1.start();
        thread2.start();
    }

    private static int compute() {
        return num++;
    }

    /**
     * 锁测试
     */
    private static void lockTest() {
        Thread thread1 = new Thread(() -> {
            MyThreadLock.lock();
            System.out.println("thread1使用锁中");
        });

        Thread thread2 = new Thread(() -> {
            MyThreadLock.lock();
            System.out.println("thread2使用锁中");
        });

    }

}
