package com.skillfactory.modules.practice;

import com.github.javafaker.Faker;
import com.skillfactory.modules.practice.model.Student;
import com.skillfactory.modules.practice.model.University;
import com.skillfactory.modules.practice.type.StudyProfile;

public class Main {

    public static void main(String[] args) {

        Faker faker = new Faker();

        University mgu = new University("mgu", "MGU", "MGU", 1789,  StudyProfile.PROGRAMMING);
        University mvtu = new University("mvtu", "MVTU", "MVTU", 1789,  StudyProfile.ASTRONOMY);

        Student elonMask = new Student(faker.name().fullName(), mgu.getId(), 5, 100);
        Student steveJobs = new Student(faker.name().fullName(), mvtu.getId(), 3, 15);

        System.out.println(mgu);
        System.out.println(mvtu);
        System.out.println(elonMask);
        System.out.println(steveJobs);
    }
}