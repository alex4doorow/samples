package com.sir.richard.boss.runtime.v3;

import java.io.IOException;

public class RuntimeMain {
    public static void main(String[] args) throws IOException {
/*
        Runtime.getRuntime()
                .exec("cmd /c start c:\\src\\diximonline\\rMaster\\rmaster-srv\\git-test-2.bat");
*/
        Runtime.getRuntime()
                .exec("c:\\src\\diximonline\\rMaster\\rmaster-srv\\git-test-2.bat");


/*
        Runtime.getRuntime()
                .exec("git log -1 --date=format-local:\"%Y%m%d%H%M%S\" --pretty=format:\"%h/%cd\" -- c:/src/diximonline/rMaster/rmaster-srv/ > c:/src/diximonline/rMaster/rmaster-srv/log.txt");
*/
    }
}
