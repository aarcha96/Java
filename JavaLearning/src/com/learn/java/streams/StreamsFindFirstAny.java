package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Optional;

public class StreamsFindFirstAny {
    public static void main(String[] args) {
        //findfirst
        Optional<Student> findFrst = StudentDataBase.getAllStudents().stream()
                .filter(a->a.getGpa()>=3.9)
                .findAny();

        if(findFrst.isPresent()){
            System.out.println(findFrst.get());
        }else{
            System.out.println("No student found");
        }

        //findAny
        Optional<Student> findAny = StudentDataBase.getAllStudents().stream()
                .filter(a->a.getGpa()>=3.9)
                .findAny();

        if(findAny.isPresent()){
            System.out.println(findAny.get());
        }else{
            System.out.println("No student found");
        }


    }
}
