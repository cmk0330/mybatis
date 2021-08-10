import com.cmk.Person;
import com.cmk.Student;
import com.cmk.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {


    @org.junit.Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person person = new Person();
        System.out.println("这个人：" + person.getName());

        Class c1 = Class.forName("com.cmk.Student");
        Class<Student> c2 = Student.class;
        Class<? extends Person> c3 = person.getClass();
        Class superclass = c1.getSuperclass();
        System.out.println(c1);
        System.out.println(c3);
        System.out.println(c2);
        System.out.println(superclass);

        Field[] fields = c1.getFields();
        for(Field field : fields) {
            System.out.println(field);
        }
        Class<?> c4 = Class.forName("com.cmk.User");
        Constructor<?> constructor = c4.getConstructor(String.class, int.class, int.class);
        User user = (User) constructor.newInstance("张无忌", 24, 12);
        System.out.println(user);
        Method setName = c4.getDeclaredMethod("setName", String.class);
        setName.invoke(user, "铁男");
        System.out.println(user.getName());
    }
}
