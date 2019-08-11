package value_and_ref;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/10
 */
public class ValueAndRefDemo {
    public static void main(String[] args) {
        Integer a = 1, b = 2;
        System.out.println("before a=" + a + " b=" + b);
        swap(a, b);
        System.out.println("after  a=" + a + " b=" + b);
    }

    private static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }
}
