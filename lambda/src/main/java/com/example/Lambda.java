package com.example;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */

public class Lambda {

    public static void main(String[] args) {

        Flyable flyable = new Flyable() {
            @Override
            public void fly(int a) {
                System.out.println("I can fly by anonymous class");
            }

            //@Override
            //public void landing() {
            //    System.out.println("I can landing by anonymous class");
            //}
        };
        flyable.fly(1);

        flyable = (t) -> System.out.println("I can fly by lambda");
        flyable.fly(1);


        Bird bird = new Bird() {
            @Override
            void fly() {
                System.out.println("I can fly by bird");
            }
        };

        // bird = () -> System.out.println("I can fly by lambda");

    }

    @FunctionalInterface
    interface Flyable {
        void fly(int a);
        //void landing();
    }

    abstract static class Bird {
        abstract void fly();
    }
}
