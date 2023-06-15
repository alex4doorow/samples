package com.skillfactory.modules.practice;

import com.skillfactory.modules.practice.model.Student;
import com.skillfactory.modules.practice.model.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        List<University> universities = ExcelLoader.loadUniversitiesFromExcel("C:\\src\\--1-skillfactory\\java\\samples\\skillfactory\\practice-24\\src\\main\\resources\\universityInfo.xlsx");
        List<Student> students = ExcelLoader.loadStudentsFromExcel("C:\\src\\--1-skillfactory\\java\\samples\\skillfactory\\practice-24\\src\\main\\resources\\universityInfo.xlsx");
        log.info("universities: {}", universities);
        log.info("students: {}", students);

    }
}