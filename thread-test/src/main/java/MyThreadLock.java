import sun.misc.Unsafe;

public class MyThreadLock {

    private static Unsafe unsafe = Unsafe.getUnsafe();
    private static int state;
    private static long fieldOffset;

    static {
        try {
            fieldOffset = unsafe.objectFieldOffset(MyThreadLock.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void lock() {
        boolean swapInt = unsafe.compareAndSwapInt(MyThreadLock.class, fieldOffset, 0, 1);
        while (!swapInt) {
            System.out.println("正在获取锁");
        }
        System.out.println("已经获取到锁");
    }

    public static void unLock() {
        state = 0;
    }
}
