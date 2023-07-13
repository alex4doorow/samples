package com.skillfactory.modules.practice.model;

import com.skillfactory.modules.practice.type.StudyProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Statistics {

    private static final Logger log = LoggerFactory.getLogger(Statistics.class);

    private StudyProfile profile;
    private double avgExamScore;
    private int numberOfStudents;
    private int numberOfUniversities;
    private String universityNames;

    public StudyProfile getProfile() {
        return profile;
    }

    public Statistics setProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(double avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public Statistics setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }

    public Statistics setNumberOfUniversities(int numberOfUniversities) {
        this.numberOfUniversities = numberOfUniversities;
        return this;
    }

    public String getUniversityNames() {
        return universityNames;
    }

    public Statistics setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
        return this;
    }
}
