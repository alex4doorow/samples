package com.skillfactory.modules.practice.utils;

import com.skillfactory.modules.practice.model.Statistics;
import com.skillfactory.modules.practice.model.Student;
import com.skillfactory.modules.practice.model.University;
import com.skillfactory.modules.practice.type.StudyProfile;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsUtils {

    private static final Logger log = LoggerFactory.getLogger(Statistics.class);

    private StatisticsUtils() {
    }

    public static List<Statistics> createStatistics(List<Student> students, List<University> universities) {

        log.debug("Statistics module: begin");

        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setProfile(profile);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setNumberOfUniversities(profileUniversityIds.size());
            statistics.setUniversityNames(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityNames(statistics.getUniversityNames() + fullNameUniversity + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setNumberOfStudents(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream().mapToDouble(Student::getAvgExamScore).average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore((float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        log.info("{}", statisticsList);
        log.debug("Statistics module: finish");
        return statisticsList;
    }
}
