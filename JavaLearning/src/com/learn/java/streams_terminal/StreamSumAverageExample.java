package com.learn.java.streams_terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

public class StreamSumAverageExample {
    public static void main(String[] args) {
        System.out.println("sum of notebooks using summingInt : "+sumOfNoteBooks());
        System.out.println("avg pf notebooks using averagingInt : "+avgNoteBook());
    }

    private static int sumOfNoteBooks(){
        return StudentDataBase.getAllStudents().stream()
                .collect(summingInt(Student::getNotebook));
    }

    private static double avgNoteBook(){
        return StudentDataBase.getAllStudents().stream()
                .collect(averagingInt(Student::getNotebook));
    }
}
