package com.skillfactory.modules.practice.model.comparator;

import com.skillfactory.modules.practice.model.Student;

import java.io.Serializable;

public class AvgExamScoreStudentComparator implements StudentComparator, Serializable {

    private static final long serialVersionUID = -8155562084438162192L;

    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
    }
}
