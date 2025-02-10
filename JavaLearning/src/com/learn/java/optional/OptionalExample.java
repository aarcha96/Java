package com.learn.java.optional;

import java.util.Optional;

public class OptionalExample {

    private static Optional<String> ofNullable() {
        Optional<String> res = Optional.ofNullable(null);
        return res;
    }

    private static Optional<String> of() {
        Optional<String> res = Optional.of("HEllo");
        return res;
    }

    private static Optional<String> emptyy() {
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println(ofNullable().isPresent());
        System.out.println(of());
        System.out.println(emptyy());
    }


}




