package com.skillfactory.modules.java.core.m10.t1041;

import java.io.*;
import java.nio.charset.Charset;

public class Main4 {

    public static void main(String[] args) throws IOException {
        copyFileUsingStream(new File("src/win1251.txt"),
                Charset.forName("windows-1251"),
                new File("src/utf8.txt"),
                Charset.forName("utf-8"));
    }

    private static void copyFileUsingStream(File source, Charset sourceEnc, File dest, Charset descEnc) throws IOException {
        Reader fis = new FileReader(source, sourceEnc);
        Writer fos = new FileWriter(dest, descEnc);
        char[] buffer = new char[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        fis.close();
        fos.close();
    }
}
