package com.learn.java.streams_terminal;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class StreamGroupingByExample {
    public static void main(String[] args) {
        groupingByGender();
        groupingByCustomised();
        groupingByV2();
        groupingByMAXBy();
        groupingBYMINBY();
        groupingByMinByCollectingThen();
    }

    private static void groupingByGender(){

        //this will group the list of students based on the genders
        //key will be gender ,values be will List<student>
        Map<String, List<Student>> studeMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGender));
        System.out.println(studeMap);
    }

    private static void groupingByCustomised() {
        //grouping students based on gpa
        //if gpa >=3.5 excellent, else average
       Map<String, List<Student>> studMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(a-> a.getGpa()>=3.5? "EXCELLENT" : "AVERAGE"));
        System.out.println(studMap);
    }

    private static void groupingByV2(){
        //grouping students based on grade and
        // for those grades who all are having  gpa>=3.5 then mark it as "EXCELLENT", ELSE Average
        Map<Integer, Map<String,List<Student>>> studeMap =StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(a->a.getGpa()>=3.5 ? "EXCELLENT" : "AVERAGE")));
        studeMap.forEach((k,v)-> System.out.println("Key : "+k+ " Values "+v));
    }

    private static void groupingByMAXBy() {
        //top gpa student in each grade
        Map<Integer, Optional<Student>> studMax = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel
                        ,maxBy(Comparator.comparing(Student::getGpa))));
        studMax.forEach((k,v)-> System.out.println("Key : "+k+ " Values "+v));
    }

    private static void groupingBYMINBY(){
        //student having less no of notebook in each grade
        Map<Integer, Optional<Student>> studMin = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel
                        ,minBy(Comparator.comparing(Student::getNotebook))));
        studMin.forEach((k,v) -> System.out.println("Key : "+k+ " Values "+v ));
    }

    private static void groupingByMinByCollectingThen(){
        //student  having less no of notebook in each grade without Optional
        System.out.println("student  having less no of notebook in each grade without Optional");
        Map<Integer, Student> stud = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(minBy(Comparator.comparing(Student::getNotebook)),Optional::get)));
        stud.forEach((k,v)-> System.out.println("Key : "+k+ " Values "+v));
    }

}
