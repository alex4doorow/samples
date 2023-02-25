package com.skillfactory.modules.java.core.m06.l03.main;

import com.skillfactory.modules.java.core.m06.l03.test.BaseClass;

public class OtherPackageSubclass extends BaseClass {
    public OtherPackageSubclass() {
        //Не получим доступ, потому что другой пакет
        /*
        this.defaultValue = 10;
        this.protectedValue = 10;
        //По ссылке не могут обращаться даже наследники BaseClass
        BaseClass a = new BaseClass();
        a.protectedValue = 10;
        */
    }
}
