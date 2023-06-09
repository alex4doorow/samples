package com.skillfactory.modules.practice;

import com.skillfactory.modules.practice.model.Student;
import com.skillfactory.modules.practice.model.University;
import com.skillfactory.modules.practice.type.StudyProfile;

public class Main {
    public static void main(String[] args) {
        University mgu = new University("mgu", "MGU", "MGU", 1789,  StudyProfile.PROGRAMMING);
        University mvtu = new University("mvtu", "MVTU", "MVTU", 1789,  StudyProfile.ASTRONOMY);

        Student elonMask = new Student("Elon Mask", mgu.getId(), 5, 100);
        Student steveJobs = new Student("Steve Jobs", mvtu.getId(), 3, 15);

        System.out.println(mgu);
        System.out.println(mvtu);
        System.out.println(elonMask);
        System.out.println(steveJobs);
    }
}