package com.learn.java.streams;

import com.learn.java.data.StudentDataBase;

public class StreamsMatchExample {

    public static void main(String[] args) {
        //allMatch
        System.out.println(StudentDataBase.getAllStudents().stream()
                .allMatch(s->s.getGpa()>=3.5));

        //anyMatch
        System.out.println(StudentDataBase.getAllStudents().stream()
        .anyMatch(s->s.getGpa()>=3.5));

        //noneMatch
        System.out.println(StudentDataBase.getAllStudents().stream()
                .noneMatch(s -> s.getGpa()>=4.3));
    }
}
