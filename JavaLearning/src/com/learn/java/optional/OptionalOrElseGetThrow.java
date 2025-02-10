package com.learn.java.optional;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseGetThrow {

    private static String orElse(){
        Optional<Student> stud = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        //Optional<Student> stud = Optional.ofNullable(null);
        return stud.map(Student::getName).orElse("DEFAULT NAME");
    }

    private static String orElseGet(){
        Optional<Student> stud = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        //Optional<Student> stud = Optional.ofNullable(null);
        return stud.map(Student::getName).orElseGet(()->"DEFAULT NAME");
    }

    private static String orElseThrow(){
        Optional<Student> stud = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        //Optional<Student> stud = Optional.ofNullable(null);
        return stud.map(Student::getName).orElseThrow(()-> new RuntimeException("No values found"));
    }

    public static void main(String[] args) {
        System.out.println(orElse());
        System.out.println(orElseGet());
        System.out.println(orElseThrow());
    }
}
