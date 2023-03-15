package com.sir.richard.boss.runtime.v4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main1(String[] args) throws IOException {
        // Change directory to the Git repository
        File repoDir = new File("c:\\src\\diximonline\\NG-Modules\\");
        System.setProperty("user.dir", repoDir.getAbsolutePath());

        // Run the Git command
        Process process;
        process = Runtime.getRuntime().exec("git status");
        process = Runtime.getRuntime().exec("git log -10 -- src/main/resources/db");

        // Read the output of the command
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        try {
            File repoDir = new File("c:/src/diximonline/NG-Modules/");
            //File repoDir = new File("c:\\src\\diximonline\\rmaster\\rmaster-srv");
            System.setProperty("user.dir", repoDir.getAbsolutePath());

            // Specify the git command and arguments
            //List<String> command = List.of("git", "log", "-1", "--date=format-local:\"%Y%m%d%H%M%S\"", "--pretty=format:\"%h/%cd\"", "--", " src/main/resources/db");
            //List<String> command = List.of("git", "status");
            //List<String> command = List.of("git", "log", "-1", "--date=format-local:\"%Y%m%d%H%M%S\"", "--pretty=format:\"%h/%cd\"", "--", " c:/src/diximonline/NG-Modules/core.db/src/main/resources/db");
            List<String> command = List.of("git", "log", "-1", "--date=format-local:\"%Y%m%d%H%M%S\"", "--pretty=format:\"%h/%cd\"", "--", "src/main/resources");

            // Create a process builder for the command
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Process exited with code " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
