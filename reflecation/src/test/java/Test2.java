import com.cmk.IField;
import com.cmk.ITable;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Test2 {

    @Test
    public void test() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.cmk.User");
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解--》" + annotation);
        }
        ITable table = aClass.getAnnotation(ITable.class);
        System.out.println(table);
        // 获取注解value
        String value = table.value();
        System.out.println(value);

        // 获取属性
        Field field = aClass.getDeclaredField("name");
        IField iField = field.getAnnotation(IField.class);
        System.out.println(iField.columnName());
        System.out.println(iField.length());
        System.out.println(iField.type());
    }
}
