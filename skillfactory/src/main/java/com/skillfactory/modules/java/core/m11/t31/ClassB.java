package com.skillfactory.modules.java.core.m11.t31;

import java.io.FileNotFoundException;
import java.io.IOException;

class ClassB extends ClassA {

    //public void f1() throws Exception {}
    public void f2() throws IOException {}
    //public void f3() throws InterruptedException, IOException {}
    public void f4() throws IOException, FileNotFoundException {}
    public void f5() throws FileNotFoundException {}
    public void f6() throws FileNotFoundException, InternalError {}

}
