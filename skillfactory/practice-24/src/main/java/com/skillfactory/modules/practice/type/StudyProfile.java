package com.skillfactory.modules.practice.type;

import org.apache.commons.lang3.StringUtils;

public enum StudyProfile {
    PROGRAMMING("PROGRAMMING", "Программирование"),
    MEDICINE("MEDICINE", "Медицина"),
    ASTRONOMY("ASTRONOMY", "Астрономия"),
    PHYSICS("PHYSICS", "Физика"),
    LINGUISTICS("LINGUISTICS", "Лингвистика"),
    MATHEMATICS("MATHEMATICS", "Математика");

    private final String profileCode;
    private final String profileName;

    StudyProfile(String profileCode, String profileName) {
        this.profileCode = profileCode;
        this.profileName = profileName;
    }

    public String getProfileCode() {
        return profileCode;
    }

    public String getProfileName() {
        return profileName;
    }

    public static StudyProfile valueOfKey(String profileKey) {
        if (StringUtils.isEmpty(profileKey)) {
            return null;
        }
        if (profileKey.equals(StudyProfile.PHYSICS.profileCode)) {
            return StudyProfile.PHYSICS;
        } else if (profileKey.equals(StudyProfile.LINGUISTICS.profileCode)) {
            return StudyProfile.LINGUISTICS;
        } else if (profileKey.equals(StudyProfile.MEDICINE.profileCode)) {
            return StudyProfile.MEDICINE;
        } else if (profileKey.equals(StudyProfile.MATHEMATICS.profileCode)) {
            return StudyProfile.MATHEMATICS;
        } else {
            return null;
        }
    }
}