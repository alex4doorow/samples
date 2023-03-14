package com.sir.richard.boss.runtime.v2;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RuntimeMain {

    static boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        String homeDirectory = "C:/src/diximonline/ng-modules/core.db";
        Process process;
        if (isWindows) {
            /*
            process = Runtime.getRuntime()
                    .exec(String.format("git log -1 > log2.log", homeDirectory));
             */
            process = Runtime.getRuntime()
                    .exec("cmd /c start \"\" c:\\src\\diximonline\\rMaster\\rmaster-srv\\git-test.bat");

        } else {
            process = Runtime.getRuntime()
                    .exec(String.format("/bin/sh -c ls %s", homeDirectory));
        }
        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);
        Future<?> future = Executors.newSingleThreadExecutor().submit(streamGobbler);

        int exitCode = process.waitFor();
        assert exitCode == 0;

        future.get(); // waits for streamGobbler to finish
    }
}
