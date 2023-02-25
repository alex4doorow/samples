package com.skillfactory.modules.java.core.m04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester{

    public static void main1(String[] args) {
        String text = "aba aba a!a abba adca abea";
        // abba adca abea
        Pattern pattern = Pattern.compile("a(.){2}a");

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("Found match: " + text.substring(start, end) + "\nfrom " + start + " to " + (end - 1));
        }

        System.out.println("Clean the text");
        System.out.println(matcher.replaceAll(""));

    }

    public static void main2(String[] args) {
        String text = "aba aba a!a abba adca abea";
        // ab
        Pattern pattern = Pattern.compile("ab.*?");

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("Found match: " + text.substring(start, end) + "\nfrom " + start + " to " + (end - 1));
        }

        System.out.println("Clean the text");
        System.out.println(matcher.replaceAll(""));

    }

    public static void main3(String[] args) {
        String text = "Happy New Year 2022 2000!";
        // 2022
        Pattern pattern = Pattern.compile("20\\d{2}");

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("Found match: " + text.substring(start, end) + "\nfrom " + start + " to " + (end - 1));
        }

        System.out.println("Clean the text");
        System.out.println(matcher.replaceAll(""));

    }

    public static void main(String[] args) {
        String text = "Regular Expressions or Regex is an API for defining String patterns that can be used for searching, manipulating and editing a text. It is widely used to define a constraint on strings such as a password. Regular Expressions are provided under java.util.regex package.";
        // все английские слова в тексте, начинающиеся и заканчивающиеся на букву s
        Pattern pattern = Pattern.compile("\\bs\\w*.?s\\b");

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("Found match: " + text.substring(start, end) + "\nfrom " + start + " to " + (end - 1));
        }

        System.out.println("Clean the text");
        System.out.println(matcher.replaceAll(""));

    }

    public static void main4(String[] args) {
        //Yaqoob[\d\s\w.",-:();=\]\\[\{\?\}\%\$\<\>\*]*
    }
}
