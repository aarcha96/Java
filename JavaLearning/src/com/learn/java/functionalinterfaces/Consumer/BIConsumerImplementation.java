package com.learn.java.functionalinterfaces.Consumer;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BIConsumerImplementation {

    public static void printNameActivities(){
        BiConsumer<String, List<String>> bc = (s1,s2)->{
            System.out.println("Name: "+s1+" Activities: "+s2);
        };
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> bc.accept(student.getName(),student.getActivities()));
    }

    public static void main(String[] args) {
        printNameActivities();
    }

}
