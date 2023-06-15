package com.skillfactory.modules.practice;

import com.skillfactory.modules.practice.model.Student;
import com.skillfactory.modules.practice.model.University;
import com.skillfactory.modules.practice.type.StudyProfile;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelLoader {

    private static final Logger log = LoggerFactory.getLogger(ExcelLoader.class);

    private ExcelLoader() {
    }

    public static List<University> loadUniversitiesFromExcel(String fileName) {
        ExcelLoader excelLoader = new ExcelLoader();
        return excelLoader.universitiesFromExcel(fileName);
    }

    public static List<Student> loadStudentsFromExcel(String fileName) {
        ExcelLoader excelLoader = new ExcelLoader();
        return excelLoader.studentsFromExcel(fileName);

    }

    private List<University> universitiesFromExcel(String fileName) {
        XSSFWorkbook myExcelBook;
        List<University> outputData = null;
        try {

            myExcelBook = new XSSFWorkbook(fileName);
            XSSFSheet myExcelSheet = myExcelBook.getSheetAt(1);

            XSSFRow row;

            int startIndex = 1;
            outputData = new ArrayList<>();

            String universityId;
            String fullName;
            String shortName;
            Double yearOfFoundation;
            String profile;

            for (int i = startIndex; i <= myExcelSheet.getLastRowNum(); i++) {
                row = myExcelSheet.getRow(i);

                University raw = null;
                if (row.getCell(0) != null && row.getCell(0).getCellType() == CellType.STRING) {
                    universityId = row.getCell(0).getStringCellValue();
                    fullName = row.getCell(1).getStringCellValue();
                    shortName = row.getCell(2).getStringCellValue();
                    yearOfFoundation = row.getCell(3).getNumericCellValue();
                    profile = row.getCell(4).getStringCellValue();
                    log.info("universityId: {}, {}, {}, {}", universityId, shortName, yearOfFoundation, profile);

                    raw = new University(universityId, fullName, shortName, yearOfFoundation.intValue(),
                            StudyProfile.valueOf(profile));

                    outputData.add(raw);
                }
            }
            myExcelBook.close();
        } catch (FileNotFoundException e) {
            log.error("FileNotFoundException:", e);
        } catch (IOException e) {
            log.error("IOException:", e);
        }
        return outputData;
    }


    private List<Student> studentsFromExcel(String fileName) {
        XSSFWorkbook myExcelBook;
        List<Student> outputData = null;
        try {
            myExcelBook = new XSSFWorkbook(fileName);
            XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
            XSSFRow row;

            int startIndex = 1;
            outputData = new ArrayList<>();

            String fullName;
            String universityId;
            Double currentCourseNumber;
            Double avgExamScore;

            for (int i = startIndex; i <= myExcelSheet.getLastRowNum(); i++) {
                row = myExcelSheet.getRow(i);

                Student raw = null;
                if (row.getCell(0) != null && row.getCell(0).getCellType() == CellType.STRING) {


                    fullName = row.getCell(0).getStringCellValue();
                    universityId = row.getCell(1).getStringCellValue();
                    currentCourseNumber = row.getCell(2).getNumericCellValue();
                    avgExamScore = row.getCell(3).getNumericCellValue();

                    raw = new Student(fullName, universityId,
                            currentCourseNumber.intValue(), avgExamScore.floatValue());
                    outputData.add(raw);
                }
            }
            myExcelBook.close();
        } catch (FileNotFoundException e) {
            log.error("FileNotFoundException:", e);
        } catch (IOException e) {
            log.error("IOException:", e);
        }
        return outputData;
    }
}
