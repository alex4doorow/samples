package com.sir.richard.boss.runtime.v4;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

public class BuildInfo {
    public static void main(String[] args) throws IOException {
        gitInfo();

        /*
        FileInputStream in = new FileInputStream("C:\\src\\--1-skillfactory\\java\\samples\\sir-richard-boss-samples\\src\\main\\resources\\upd\\upd.properties");
        Properties props = new Properties();
        props.load(in);
        System.out.println(props);
        in.close();

        FileOutputStream out = new FileOutputStream("C:\\src\\--1-skillfactory\\java\\samples\\sir-richard-boss-samples\\src\\main\\resources\\upd\\upd.properties");
        props.setProperty("com.diximonline.upd.git.db.build", "0034567/20230301132212");
        props.store(out, null);
        out.close();

        */

    }

    public static void gitInfo() {
        try {
            File repoDir = new File("c:/src/--1-skillfactory/java/samples/sir-richard-boss-samples/");
            System.setProperty("user.dir", repoDir.getAbsolutePath());
            List<String> command = List.of("git", "log", "-10", "--date=format-local:\"%Y%m%d%H%M%S\"", "--pretty=format:\"%h/%cd\"", "--", " ", "c:/src/--1-skillfactory/java/samples/sir-richard-boss-samples/src/main/resources/db");

            // Create a process builder for the command
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {

                FileInputStream in = new FileInputStream("C:\\src\\--1-skillfactory\\java\\samples\\sir-richard-boss-samples\\src\\main\\resources\\upd\\upd.properties");
                Properties props = new Properties();
                props.load(in);
                //System.out.println(props);
                in.close();

                FileOutputStream out = new FileOutputStream("C:\\src\\--1-skillfactory\\java\\samples\\sir-richard-boss-samples\\src\\main\\resources\\upd\\upd.properties");
                props.setProperty("com.diximonline.upd.git.db.build", line);
                props.store(out, null);
                out.close();

                //System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*

    public static void main(String[] args) {
        String javaVersion = Runtime.version().toString();
        String time = LocalDateTime.now().toString();
        System.out.println("********\nBuild Time: " + time
                + "\nJava Version: " + javaVersion + "\n********");
    }

     */
}
