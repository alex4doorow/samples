package com.skillfactory.modules.practice.model.comparator;

import com.skillfactory.modules.practice.model.Student;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class FullNameStudentComparator implements StudentComparator, Serializable {

    private static final long serialVersionUID = -6769481051683884150L;

    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());        
    }

}
