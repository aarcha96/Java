package com.learn.java.lambda;

public class RunnableImplement {

    public static void main(String[] args) {

        //legacy implementation for runnable(before java8)
        //creating anonymonus class to run in it
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Runnable Legacy");
            }
        };
        new Thread(runnable).start();


        //java 8 implementation for runnable usinng lambda
        Runnable runnable1 = () -> System.out.println("Runnable using lambda");
        new Thread(runnable1).start();

        //more concise code
        new Thread(()->System.out.println("Runnable using lambda in one line")).start();
    }

}
