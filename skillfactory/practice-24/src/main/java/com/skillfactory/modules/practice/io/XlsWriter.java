package com.skillfactory.modules.practice.io;

import com.skillfactory.modules.practice.model.Statistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class XlsWriter {

    private static final Logger log = LoggerFactory.getLogger(XlsWriter.class);

    public XlsWriter() {
    }

    public static void writeXlsStatistics(List<Statistics> statisticsList, String filePath) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statisticsSheet = workbook.createSheet("stat");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        int index = 0;
        Row headerRow = statisticsSheet.createRow(index++);

        Cell profileCellHeader = headerRow.createCell(0);
        profileCellHeader.setCellValue("Profile");
        profileCellHeader.setCellStyle(headerStyle);

        Cell avgScoreCellHeader = headerRow.createCell(1);
        avgScoreCellHeader.setCellValue("Avarage");
        avgScoreCellHeader.setCellStyle(headerStyle);

        Cell numberOfStudentsCellHeader = headerRow.createCell(2);
        numberOfStudentsCellHeader.setCellValue("Students count");
        numberOfStudentsCellHeader.setCellStyle(headerStyle);

        Cell numberOfUniversitiesCellHeader = headerRow.createCell(3);
        numberOfUniversitiesCellHeader.setCellValue("Universities count");
        numberOfUniversitiesCellHeader.setCellStyle(headerStyle);

        Cell universitiesCellHeader = headerRow.createCell(4);
        universitiesCellHeader.setCellValue("Universities");
        universitiesCellHeader.setCellStyle(headerStyle);

        for (Statistics statistics : statisticsList) {
            Row dataRow = statisticsSheet.createRow(index++);

            Cell profileCell = dataRow.createCell(0);
            profileCell.setCellValue(statistics.getProfile().getProfileName());

            Cell avgScoreCell = dataRow.createCell(1);
            avgScoreCell.setCellValue(statistics.getAvgExamScore());

            Cell numberOfStudentsCell = dataRow.createCell(2);
            numberOfStudentsCell.setCellValue(statistics.getNumberOfStudents());

            Cell numberOfUniversitiesCell = dataRow.createCell(3);
            numberOfUniversitiesCell.setCellValue(statistics.getNumberOfUniversities());

            Cell universitiesCell = dataRow.createCell(4);
            universitiesCell.setCellValue(statistics.getUniversityNames());
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            log.error("FileNotFoundException:", e);
        } catch (Exception e) {
            log.error("Exception:", e);
        }
    }
}
