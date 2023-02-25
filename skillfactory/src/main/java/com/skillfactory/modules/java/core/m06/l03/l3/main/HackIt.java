package com.skillfactory.modules.java.core.m06.l03.l3.main;

import com.skillfactory.modules.java.core.m06.l03.l3.anotherfirm.Secret;

public class HackIt {

    public static void main(String[] args) {
        (new Hack()).hack();
    }
}

class Hack extends Secret {
    public void hack() {
        getSecret();
    }
}