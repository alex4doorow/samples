package com.sir.richard.boss.algorithms;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SortingByBubblesMain {

    private static Integer[] checkingArray;

    private void createArray(int count) {
        checkingArray = new Integer[count];
        for (int i = 0; i <= count - 1; i++) {
            checkingArray[i] = Faker.instance().number().numberBetween(1, count * count);
        }
    }

    private Integer[] sortingArray(Integer[] arr) {
        Integer[] resultArray = Arrays.copyOf(arr, arr.length);
        int count = arr.length;

        while (isNotSorting(resultArray)) {
            for (int i = 0; i <= count - 1; i++) {
                resultArray = reCoursingSortingArrayStep(arr, i);
            }
        }
        return resultArray;
    }

    private boolean isNotSorting(Integer[] arr) {
        int count = arr.length;
        for (int i = 0; i <= count - 1; i++) {
            if (i == count - 1) {
                break;
            }
            if (arr[i] > arr[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private Integer[] reCoursingSortingArrayStep(Integer[] arr, int index) {
        if (index == arr.length - 1) {
            return arr;
        }
        int a = arr[index];
        int b = arr[index + 1];
        if (b > a) {
            arr[index] = a;
            arr[index + 1] = b;
        } else {
            arr[index] = b;
            arr[index + 1] = a;
        }
        return arr;
    }

    public static void main(String[] args) {
        SortingByBubblesMain main = new SortingByBubblesMain();
        int count = 15;
        main.createArray(count);
        printArray(checkingArray);

        Integer[] intArr = Arrays.copyOf(checkingArray, checkingArray.length);
        printArray(intArr);
        //printArray(count);
        Integer[] intArr2 = main.sortingArray(checkingArray);
        printArray(intArr2);

        //main.createArray(count);
        //System.out.println(intArr);
        List<Integer> ints = Stream.of(checkingArray).sorted().toList();
        System.out.println(ints);

        Object[] rr = Stream.of(checkingArray).sorted().toArray();
        for (int i = 0; i <= rr.length - 1; i++) {
            System.out.println(rr[i]);
        }

        Integer[] rr2 = Stream.of(checkingArray).sorted().toArray(Integer[]::new);






    }

    private static void printArray(Integer[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("\n\r");
    }


}
