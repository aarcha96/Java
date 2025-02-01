package com.learn.java.streams;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8, 2, 3, 4, 0, 6, 7, 1, 9, 10);
        //limitReduceExample(list);
        //skipReduceExample(list);
        studExample();
    }

    private static void skipReduceExample(List<Integer> list) {
        Optional<Integer> skip = list.stream()
                .skip(6)
                .reduce(Integer::sum);
        if (skip.isPresent()) {
            System.out.println(skip.get());
        }else{
            System.out.println("List is empty");
        }
    }

    private static void limitReduceExample(List<Integer> list) {
        Optional<Integer> lim = list.stream()
                .limit(4)
                .reduce(Integer::sum);
        if (lim.isPresent()) {
            System.out.println(lim.get());
        }else{
            System.out.println("list empty");
        }
    }

    //students who is having  highest no of notebook and also a male and grade >=3
    private static void studExample() {
        StudentDataBase.getAllStudents()
                .stream()
                .filter(s->s.getGender().equals("male"))
                .filter(s->s.getGradeLevel()>=3)
                .sorted(Comparator.comparing(Student::getNotebook))
                .skip(1)
                .forEach(System.out::println);
    }
}
