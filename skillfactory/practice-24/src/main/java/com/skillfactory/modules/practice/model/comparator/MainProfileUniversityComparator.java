package com.skillfactory.modules.practice.model.comparator;

import com.skillfactory.modules.practice.model.University;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class MainProfileUniversityComparator implements UniversityComparator, Serializable {

    private static final long serialVersionUID = -8845312138298572541L;

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getMainProfile().getProfileCode(), o2.getMainProfile().getProfileCode());
    }

}
