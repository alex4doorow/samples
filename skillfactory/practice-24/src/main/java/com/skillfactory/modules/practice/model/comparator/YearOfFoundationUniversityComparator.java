package com.skillfactory.modules.practice.model.comparator;

import com.skillfactory.modules.practice.model.University;

import java.io.Serializable;

public class YearOfFoundationUniversityComparator implements UniversityComparator, Serializable {


    private static final long serialVersionUID = 8604054560605711934L;

    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }

}