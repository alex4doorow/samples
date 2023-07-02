package com.skillfactory.modules.practice.model.comparator;

import com.skillfactory.modules.practice.model.University;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class ShortNameUniversityComparator implements UniversityComparator, Serializable {


    private static final long serialVersionUID = 8604054560605711934L;

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }

}