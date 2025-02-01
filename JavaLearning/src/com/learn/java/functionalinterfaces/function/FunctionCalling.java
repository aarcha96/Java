package com.learn.java.functionalinterfaces.function;

public class FunctionCalling {

    public static String ToCall(String str) {
        return FunctionImplementation.function2.apply(str);
    }

    public static void main(String[] args){
        System.out.println(ToCall("Hello"));
    }
}
