/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/11
 */
class A {
    public A() {
        System.out.println("class A");
    }

    {
        System.out.println("I'm A class");
    }
    // ①
    static {
        System.out.println("class A static");
    }
}

public class B extends A {
    public B() {
        System.out.println("class B");
    }

    {
        System.out.println("I'm B class");
    }
//
    static {
        System.out.println("class B static");
    }

    public static void main(String[] args) {
        new B();
    }
}