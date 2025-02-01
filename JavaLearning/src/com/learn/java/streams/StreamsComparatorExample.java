package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;

public class StreamsComparatorExample {

    public static void main(String[] args) {

        //sort Student based on name
        List<Student> sortedStudents = StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName)).toList();

        sortedStudents.forEach(System.out::println);

        System.out.println(" sorting based on gpa");
        //sort students based on gpa
        StudentDataBase.getAllStudents().stream().
                sorted(Comparator.comparingDouble(Student::getGpa)).forEach(System.out::println);

        System.out.println("sorting based on grade level in reverse order");
        StudentDataBase.getAllStudents().stream().sorted(Comparator.comparingInt(Student::getGradeLevel).reversed()).forEach(System.out::println);

    }
}
