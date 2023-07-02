package com.skillfactory.modules.practice.type;

import com.skillfactory.modules.practice.model.comparator.*;

public enum UniversityComparators {
    ShortNameUniversityComparator,
    FullNameUniversityComparator,
    IdUniversityComparator,
    MainProfileUniversityComparator,
    YearOfFoundationUniversityComparator;

    public static UniversityComparator getComparatorByType(UniversityComparators type) {
        if (type == ShortNameUniversityComparator) {
            return new ShortNameUniversityComparator();
        }
        if (type == FullNameUniversityComparator) {
            return new FullNameUniversityComparator();
        }
        if (type == IdUniversityComparator) {
            return new IdUniversityComparator();
        }
        if (type == MainProfileUniversityComparator) {
            return new MainProfileUniversityComparator();
        }
        if (type == YearOfFoundationUniversityComparator) {
            return new YearOfFoundationUniversityComparator();
        }
        return null;
    }
}
