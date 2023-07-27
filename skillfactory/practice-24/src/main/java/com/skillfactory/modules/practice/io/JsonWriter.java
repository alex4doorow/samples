package com.skillfactory.modules.practice.io;

import com.skillfactory.modules.practice.model.FullInfo;
import com.skillfactory.modules.practice.utils.JsonUtil;
import com.skillfactory.modules.practice.utils.PracticeConfig;
import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class JsonWriter {

    private JsonWriter() {
    }

    public static void writeJsonReq(FullInfo fullInfo) {

        log.info("JSON writing started");

        PracticeConfig.distCreateIfNotExist();

        writeStudents(fullInfo);
        writeUniversities(fullInfo);
        writeStatisticsList(fullInfo);

        log.info("JSON writing finished successfully");
    }

    private static void writeStudents(FullInfo fullInfo) {
        String studentsJson = JsonUtil.writeListToJson(fullInfo.getStudentList());
        try (FileOutputStream outputStream = new FileOutputStream(PracticeConfig.DIST + "json-students-" + fullInfo.getProcessDate().getTime() + ".json")) {
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.error("Students JSON writing failed", e);
        }
    }

    private static void writeUniversities(FullInfo fullInfo) {
        String universitiesJson = JsonUtil.writeListToJson(fullInfo.getUniversityList());
        try (FileOutputStream outputStream = new FileOutputStream(PracticeConfig.DIST + "json-universities-" + fullInfo.getProcessDate().getTime() + ".json")) {
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.error("Universities JSON writing failed", e);
        }
    }

    private static void writeStatisticsList(FullInfo fullInfo) {
        String studentsJson = JsonUtil.writeListToJson(fullInfo.getStatisticsList());
        try(FileOutputStream outputStream = new FileOutputStream(PracticeConfig.DIST + "json-statistics-" + fullInfo.getProcessDate().getTime() + ".json"))  {
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.error("Statistics JSON writing failed", e);
        }
    }
}