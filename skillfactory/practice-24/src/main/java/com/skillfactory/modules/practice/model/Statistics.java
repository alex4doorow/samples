package com.skillfactory.modules.practice.model;

import com.skillfactory.modules.practice.type.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

    @XmlElement(name = "profile")
    private StudyProfile profile;
    @XmlElement(name = "avgExamScore")
    private double avgExamScore;

    @XmlElement(name = "numberOfStudents")
    private int numberOfStudents;
    @XmlElement(name = "numberOfUniversities")
    private int numberOfUniversities;
    @XmlElement(name = "universityNames")
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
