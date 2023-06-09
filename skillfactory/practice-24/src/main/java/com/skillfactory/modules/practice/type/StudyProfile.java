package com.skillfactory.modules.practice.type;

public enum StudyProfile {
    PROGRAMMING("Программирование"),
    MEDICINE("Медицина"),
    ASTRONOMY("Астрономия");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
