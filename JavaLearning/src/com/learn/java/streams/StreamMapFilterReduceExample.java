package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Optional;

public class StreamMapFilterReduceExample {

    //total no of notebooks of students
    private static Integer noteBooksum(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getNotebook).reduce(0,Integer::sum);
    }

    //total no of notebooks of students whose grade>=3 and gender==female
    private static int notebookGradeSum(){
        return StudentDataBase.getAllStudents().stream()
                .filter(s->s.getGradeLevel()>=3).
                filter(s->s.getGender().equals("female"))
                .map(Student::getNotebook).reduce(0,Integer::sum);
    }
    public static void main(String[] args) {
        System.out.println(noteBooksum());;
        System.out.println(notebookGradeSum());
    }
}
