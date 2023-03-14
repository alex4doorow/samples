package com.sir.richard.boss.runtime.v1;

import java.io.IOException;
import java.io.InputStream;

public class RuntimeMain {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        InputStream is;
        try {
            //Process p1 = null;
            Process p1 = runtime.exec("cmd.exe /X /C \"git log -1 rev-parse --verify --short=7 HEAD\"");
            //Process p1 = runtime.exec("cmd.exe /X /C \"git log -1 --date=format-local:\"%Y%m%d%H%M%S\" --pretty=format:\"%h/%cd\" -- src/main/resources/db\"");
            is = p1.getInputStream();
            int i = 0;
            while ((i = is.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
