package com.sir.richard.boss.runtime.v4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

public class BuildInfo {
    public static void main(String[] args) throws IOException {
        // mvn clean install -Dmaven.test.skip=true exec:java
        gitInfo();
    }

    public static void gitInfo() {
        try {
            System.out.println(System.getProperty("user.dir"));

            File repoDir = new File("c:/src/--1-skillfactory/java/samples/sir-richard-boss-samples/");
            System.setProperty("user.dir", repoDir.getAbsolutePath());
            List<String> command = List.of("git", "log", "-1", "--date=format-local:\"%Y%m%d%H%M%S\"", "--pretty=format:\"%h/%cd\"", "--", " ", "c:/src/--1-skillfactory/java/samples/sir-richard-boss-samples/src/main/resources/db");

            // Create a process builder for the command
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {

                InputStream in = new FileInputStream("C:\\src\\--1-skillfactory\\java\\samples\\sir-richard-boss-samples\\src\\main\\resources\\upd\\upd.properties");
                Properties props = new Properties();
                props.load(in);

                Optional<String> opt = Optional.of(props.getProperty("com.diximonline.upd.git.db.build"));

                System.out.println(opt.get());
                in.close();

                OutputStream out = new FileOutputStream("C:\\src\\--1-skillfactory\\java\\samples\\sir-richard-boss-samples\\src\\main\\resources\\upd\\upd.properties");
                props.setProperty("com.diximonline.upd.git.db.build", line);
                props.store(out, "git value of modify db");
                out.close();

                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
