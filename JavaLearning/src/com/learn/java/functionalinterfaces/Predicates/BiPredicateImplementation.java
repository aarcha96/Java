package com.learn.java.functionalinterfaces.Predicates;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateImplementation {

    public static void main(String[] args) {
        List< Student> students = StudentDataBase.getAllStudents();
        BiPredicate<Integer,Double> biPredicate = (grade,gpa)-> (grade >=3 && gpa>=3);
        students.forEach((student -> {
            if(biPredicate.test(student.getGradeLevel(),student.getGpa())){
                System.out.println(student);
            }
        }));
    }

}
