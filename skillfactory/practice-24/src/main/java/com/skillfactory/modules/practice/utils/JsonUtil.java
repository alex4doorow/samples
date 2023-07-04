package com.skillfactory.modules.practice.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.skillfactory.modules.practice.model.Student;
import com.skillfactory.modules.practice.model.University;

import java.util.List;

public class JsonUtil {

    private JsonUtil() {

    }

    public static String studentToJson(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static Student jsonToStudent(String json) {
        return new Gson().fromJson(json, Student.class);
    }

    public static String universityToJson(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static University jsonToUniversity(String json) {
        return new Gson().fromJson(json, University.class);
    }

    public static String studentsToJson(List<Student> students) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }

    public static List<Student> jsonToStudents(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }

    public static String universitiesToJson(List<University> universities) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }

    public static List<University> jsonToUniversities(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    }
}
