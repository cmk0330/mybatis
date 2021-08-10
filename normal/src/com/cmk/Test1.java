package com.cmk;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        run1();
        run2();
        run3();
        run4();
    }

    // 普通方式
    public static void run1() {
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
             user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式:" + (endTime - startTime)+ "ms");
    }

    // 反射方式
    public static void run4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class aClass = user.getClass();
        Method getName = aClass.getDeclaredMethod("getName", null);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方式2:" + (endTime - startTime) + "ms");
    }

    // 反射方式
    public static void run2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class aClass = user.getClass();
        Method getName = aClass.getDeclaredMethod("getName", null);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方式:" + (endTime - startTime) + "ms");
    }

    // 反射方式 关闭检测
    public static void run3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class aClass = user.getClass();
        Method getName = aClass.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方式:" + (endTime - startTime)+ "ms");
    }
}
