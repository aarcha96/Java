package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        //map students with name and activities using stream
        Map<String, List<String>> stud = StudentDataBase.getAllStudents().stream().collect(Collectors.toMap(Student::getName,Student::getActivities));
        System.out.println(stud);

        //map students with name and activities whose grade >=3 using stream
        Map<String,List<String>> studgrade =StudentDataBase.getAllStudents().stream().filter(s->s.getGradeLevel()>=3).collect(Collectors.toMap(Student::getName,Student::getActivities));
        System.out.println(studgrade);

        //map students with name and activities whose grade >=3 and gpa>=3 using stream
        Predicate<Student> p = s->s.getGradeLevel()>=3;
        Predicate<Student> p2 = p.and(s->s.getGpa()>=3);

        Map<String,List<String>> studgradegpa = StudentDataBase.getAllStudents().stream().filter(p2).collect(Collectors.toMap(Student::getName,Student::getActivities));
        System.out.println(studgradegpa);

        
    }

}
