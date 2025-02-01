package com.learn.java.functionalinterfaces.function;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import com.learn.java.functionalinterfaces.Predicates.PredicateImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionImplementation {

    static Function<String, String> function = (name) -> name.toUpperCase();

    static  Function<String, String> function2 = (name) -> name.toUpperCase().concat("java8");

    //map student name with GPA
    static  Function<List<Student>, Map<String,Double>> studentFunction = (students ) ->{
        Map<String,Double> map = new HashMap<>();
        students.forEach(student->{
            map.put(student.getName(),student.getGpa());
        });
        return map;
    };

    //map student with grade
    static Function<List<Student>,Map<String,Integer>> studGradeFunction = (students)->{
        Map<String,Integer> hashMap = new HashMap<>();
        students.forEach(student->{
            hashMap.put(student.getName(), student.getGradeLevel());
        });
        return hashMap;
    };

    //map student with grade>3
    static Function<List<Student>,Map<String,Integer>> studGradeFunctionGreaterThree = (students)->{
        Map<String,Integer> hashMap = new HashMap<>();
        students.forEach(student->{
            if(PredicateImplementation.studentPredicate.test(student)){
                hashMap.put(student.getName(), student.getGradeLevel());
            }
        });
        return hashMap;
    };

    //bifunction example: map stud name, gpa for students having gpa>3
    static BiFunction<List<Student>, Predicate<Student>,Map<String, Double>> biFunction = (students,studentPredicate)->{
        Map<String,Double> map = new HashMap<>();
        students.forEach(student->{
            if(studentPredicate.test(student)){
                map.put(student.getName(),student.getGpa());
            }
        });
        return map;
    };

    public static void main(String[] args) {
        /*System.out.println(function.apply("Hello"));

        System.out.println(function2.andThen(function).apply("Hii"));

        System.out.println(function.andThen(function2).apply("Hello"));

        System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));

        System.out.println(studGradeFunction.apply(StudentDataBase.getAllStudents()));

        System.out.println(studGradeFunctionGreaterThree.apply(StudentDataBase.getAllStudents()));
        */
        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(),PredicateImplementation.studentPredicate2));
    }
}
