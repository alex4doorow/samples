package com.skillfactory.modules.practice.utils;

import com.skillfactory.modules.practice.model.comparator.*;
import com.skillfactory.modules.practice.type.StudentComparators;
import com.skillfactory.modules.practice.type.UniversityComparators;

public class ComparatorUtils {
    public static StudentComparator getStudentComparator(StudentComparators type) {
        return StudentComparators.getComparatorByType(type);
    }

    public static UniversityComparator getUniversityComparator(UniversityComparators type) {
        return UniversityComparators.getComparatorByType(type);
    }
}
