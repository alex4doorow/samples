package com.skillfactory.modules.practice;

import com.skillfactory.modules.practice.model.Student;
import com.skillfactory.modules.practice.model.University;
import com.skillfactory.modules.practice.model.comparator.StudentComparator;
import com.skillfactory.modules.practice.model.comparator.UniversityComparator;
import com.skillfactory.modules.practice.type.StudentComparators;
import com.skillfactory.modules.practice.type.UniversityComparators;
import com.skillfactory.modules.practice.utils.ComparatorUtils;
import com.skillfactory.modules.practice.utils.JsonUtil;
import org.apache.commons.io.output.CloseShieldOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        List<StudentComparator> studentComparators = new ArrayList<>();
        Arrays.stream(StudentComparators.values()).forEach(sc -> {
            studentComparators.add(ComparatorUtils.getStudentComparator(sc));
        });
        log.info("studentComparators: {}", studentComparators);

        List<UniversityComparator> universityComparators = new ArrayList<>();
        Arrays.stream(UniversityComparators.values()).forEach(sc -> {
            universityComparators.add(ComparatorUtils.getUniversityComparator(sc));
        });
        log.info("studentComparators: {}", studentComparators);

        List<University> universities = ExcelLoader.loadUniversitiesFromExcel("C:\\src\\--1-skillfactory\\java\\samples\\skillfactory\\practice-24\\src\\main\\resources\\universityInfo.xlsx");
        universityComparators.forEach(comparator -> {
            log.info("*** u comparator: {}", comparator.getClass());
            universities.stream()
                    .sorted(comparator)
                    .forEach(System.out::println);
        });

        List<Student> students = ExcelLoader.loadStudentsFromExcel("C:\\src\\--1-skillfactory\\java\\samples\\skillfactory\\practice-24\\src\\main\\resources\\universityInfo.xlsx");
        studentComparators.forEach(comparator -> {
            log.info("*** s comparator: {}", comparator.getClass());
            students.stream()
                    .sorted(comparator)
                    .forEach(System.out::println);
        });
        log.info("universities: {}", universities);

        log.info("gson serializable universities: {}", JsonUtil.universitiesToJson(universities));
        log.info("gson serializable students: {}", JsonUtil.studentsToJson(students));

        List<University> nUniversities = JsonUtil.jsonToUniversities(JsonUtil.universitiesToJson(universities));
        List<Student> nStudents = JsonUtil.jsonToStudents(JsonUtil.studentsToJson(students));

        assert nUniversities.size() == universities.size();
        assert nStudents.size() == students.size();

        log.info("serialization universities:");
        universities.forEach(u -> {
            String nu = JsonUtil.universityToJson(u);
            System.out.println(nu);
            University nUniversity = JsonUtil.jsonToUniversity(nu);
            System.out.println(nUniversity);
        });

        log.info("serialization students:");
        students.forEach(s -> {
            String ns = JsonUtil.studentToJson(s);
            System.out.println(ns);
            Student nStudent = JsonUtil.jsonToStudent(ns);
            System.out.println(nStudent);
        });
    }
}