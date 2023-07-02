package com.skillfactory.modules.practice.type;

import com.skillfactory.modules.practice.model.comparator.*;

public enum StudentComparators {
    AvgExamScoreStudentComparator,
    CurrentCourseNumberStudentComparator,
    FullNameStudentComparator,
    UniversityIdStudentComparator;

    public static StudentComparator getComparatorByType(StudentComparators type) {
        if (type == AvgExamScoreStudentComparator) {
            return new AvgExamScoreStudentComparator();
        }
        if (type == CurrentCourseNumberStudentComparator) {
            return new CurrentCourseNumberStudentComparator();
        }
        if (type == FullNameStudentComparator) {
            return new FullNameStudentComparator();
        }
        if (type == UniversityIdStudentComparator) {
            return new UniversityIdStudentComparator();
        }
        return null;
    }
}
