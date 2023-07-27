package com.skillfactory.modules.practice.model;

import com.google.gson.annotations.SerializedName;
import com.skillfactory.modules.practice.type.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @SerializedName("ID")
    @XmlElement(name = "ID")
    private String id;
    @SerializedName("FullName")
    @XmlElement(name = "FullName")
    private String fullName;
    @SerializedName("ShortName")
    @XmlElement(name = "ShortName")
    private String shortName;
    @SerializedName("YearOfFoundation")
    @XmlElement(name = "YearOfFoundation")
    private int yearOfFoundation;
    @SerializedName("MainProfile")
    @XmlElement(name = "YearOfFoundation")
    private StudyProfile mainProfile;

    public University() {
    }

    public University(String id,
                      String fullName,
                      String shortName,
                      int yearOfFoundation,
                      StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}
