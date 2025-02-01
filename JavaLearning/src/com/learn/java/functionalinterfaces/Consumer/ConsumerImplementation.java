package com.learn.java.functionalinterfaces.Consumer;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerImplementation {
    static Consumer<Student> c1 = (a)-> System.out.print(a.getName());
    static Consumer<Student> c2 = (a)-> System.out.println(a.getActivities());

    public static void main(String[] args) {
        Consumer<String> consumer = (a)-> System.out.println(a.toUpperCase());
        consumer.accept("java8learning");
        //printSttudent();

        //printStudentNAMEAndACTIVITIES();
        printStudentsHavingGRadeANDGPAGreaterThan3();
    }

    public static void printStudentNAMEAndACTIVITIES() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(c1.andThen(c2));
    }

    private static void printStudentsHavingGRadeANDGPAGreaterThan3() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach((a->{
            if(a.getGradeLevel()>3 && a.getGpa()>3){
                c1.andThen(c2).accept(a);
            }
        }));
    }

    public static void printSttudent(){
        Consumer<Student> consumer = (a)-> System.out.println(a);
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(consumer);
    }
}
