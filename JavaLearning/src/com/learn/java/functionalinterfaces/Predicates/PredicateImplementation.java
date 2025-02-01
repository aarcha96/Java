package com.learn.java.functionalinterfaces.Predicates;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateImplementation {
    static  Predicate<Integer> predicate = (a)->a%2==0;
    static  Predicate<Integer> predicate2 = (a)->a%5==0;
    static List<Student> students = StudentDataBase.getAllStudents();
    public static  Predicate<Student> studentPredicate = (student) -> student.getGradeLevel()>=3;
    public static Predicate<Student> studentPredicate2 = (student -> student.getGpa()>=3);
    public static void main(String[] args) {
                //System.out.println(predicate.test(9)? "number is even": " number is odd");
                //predicateAnd();
        //predicateOr();
        //predicateNegate();
        //predicateStudGradeGreaterThanThree();
        filterStudents();
    }

    private static void filterStudents() {
        students.forEach(student -> {
            if(studentPredicate.and(studentPredicate2).test(student)){
                System.out.println( student);
            }
        });
    }

    private static void predicateStudGradeGreaterThanThree() {
        students.forEach(student->{
            if(studentPredicate.test(student)){
                System.out.println("Student with grade level 3 is greater than 3. "+ student.getName());
            }
        });

    }

    public static void predicateAnd(){
        //number divisble by both
        System.out.println(predicate.and(predicate2).test(10));
    }

    public static void predicateOr(){
        //number divisble by either
        System.out.println(predicate.or(predicate2).test(3));
    }

    public static void predicateNegate(){
        //negate
        System.out.println(predicate.negate().test(4));
    }
}
