package com.cmk;

import java.lang.annotation.*;

public class MyAnnotation {

    @IAnnotation(name = "haha", school = {"清华"})
    public void test() {

    }



    // 定义一个注解
    // Target 表示注解可以用在那个地方
    @Target(value={ElementType.METHOD, ElementType.TYPE})
     // Retention 表示在什么时期执行
    @Retention(RetentionPolicy.RUNTIME)
    // Inherited 表示子类可以继承父类的注解
    @Inherited
    @interface Study {
        String value();
    }

    @Target(value = {ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface IAnnotation {
        String name() default "";
        int age() default 0;
        int id() default -1; // -1表示不存在
        String[] school();
    }
}
