package com.skillfactory.modules.practice;

import com.skillfactory.modules.practice.io.ExcelLoader;
import com.skillfactory.modules.practice.io.XlsWriter;
import com.skillfactory.modules.practice.model.Statistics;
import com.skillfactory.modules.practice.model.Student;
import com.skillfactory.modules.practice.model.University;
import com.skillfactory.modules.practice.model.comparator.StudentComparator;
import com.skillfactory.modules.practice.model.comparator.UniversityComparator;
import com.skillfactory.modules.practice.type.StudentComparators;
import com.skillfactory.modules.practice.type.UniversityComparators;
import com.skillfactory.modules.practice.utils.ComparatorUtils;
import com.skillfactory.modules.practice.utils.JsonUtil;
import com.skillfactory.modules.practice.utils.StatisticsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.LogManager;


public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

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
            log.debug("{}", nu);
            University nUniversity = JsonUtil.jsonToUniversity(nu);
            log.debug("{}", nUniversity);
        });

        log.info("serialization students:");
        students.forEach(s -> {
            String ns = JsonUtil.studentToJson(s);
            log.debug("{}", ns);
            Student nStudent = JsonUtil.jsonToStudent(ns);
            log.debug("{}", nStudent);
        });

        List<Statistics> statisticsList = StatisticsUtils.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList,
                "C:\\src\\--1-skillfactory\\java\\samples\\skillfactory\\practice-24\\src\\main\\resources\\statistic.xlsx");
    }
}