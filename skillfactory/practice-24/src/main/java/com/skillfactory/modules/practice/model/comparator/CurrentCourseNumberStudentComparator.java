package com.skillfactory.modules.practice.model.comparator;

import com.skillfactory.modules.practice.model.Student;

import java.io.Serializable;

public class CurrentCourseNumberStudentComparator implements StudentComparator, Serializable {

    private static final long serialVersionUID = -5734838234052377629L;

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
