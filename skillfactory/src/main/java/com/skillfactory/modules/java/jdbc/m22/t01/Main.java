package com.skillfactory.modules.java.jdbc.m22.t01;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Main {

    private static final String URL = "jdbc:postgresql://localhost/sf-test?user=postgres&password=postgres";

    private final static String conok = "Соединение с бд установлено";
    private final static String conerr = "Произошла ошибка подключения к бд";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            System.out.println(String.format("%s", conok));
        } catch (SQLException e) {
            System.out.println(String.format("%s", conerr));
            log.error(e.getMessage(), e);
        }
    }
}
