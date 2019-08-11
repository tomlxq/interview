package value_and_ref;

import java.lang.reflect.Field;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/10
 */
public class ValueAndRefReflectDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1, b = 2;
        System.out.println("before a=" + a + " b=" + b);
        swap(a, b);
        System.out.println("after  a=" + a + " b=" + b);
    }

    private static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        Integer tmp =new Integer(a.intValue()) ;//强制指向另一个地址
        field.set(a,b.intValue());
        field.set(b,tmp);
    }
}
