package com.example.serv;

import java.io.PrintWriter;

public interface DatabaseInt {
    boolean connect();
    void createSample();
    void querry(PrintWriter messageWriter);
    void close();
}
