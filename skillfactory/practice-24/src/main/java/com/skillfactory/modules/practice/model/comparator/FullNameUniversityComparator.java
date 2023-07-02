package com.skillfactory.modules.practice.model.comparator;

import com.skillfactory.modules.practice.model.University;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class FullNameUniversityComparator implements UniversityComparator, Serializable {

    private static final long serialVersionUID = 1184455744229272621L;

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }

}