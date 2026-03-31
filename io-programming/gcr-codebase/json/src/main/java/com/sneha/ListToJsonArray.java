package com.sneha;

import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

class Student {
    public String name;
    public int age;
    public String course;

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {

        List<Student> students = Arrays.asList(
                new Student("Sneha", 21, "Computer Science"),
                new Student("Amit", 22, "Mechanical"),
                new Student("Riya", 20, "Electronics")
        );

        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writeValueAsString(students);

        System.out.println(jsonArray);
    }
}
