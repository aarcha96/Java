package com.learn.java.functionalinterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<List<Student>> supplier = ()-> StudentDataBase.getAllStudents();
        supplier.get().forEach(System.out::println);
    }
}
