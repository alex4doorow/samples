package com.example.serv;

import java.io.PrintWriter;
import java.sql.*;

class H2Database implements DatabaseInt {
    private static H2Database instance;
    private static Statement statement;

    public static H2Database getInstance() {
        if (instance == null) {
            instance = new H2Database();
        }
        return instance;
    }

    public boolean connect() {
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:mem:");
            statement = con.createStatement();
            return true;
        } catch (SQLException sqlException) {
            return false;
        }
    }

    public void createSample() {
        String SQL = "CREATE table testone(ID INT NOT NULL AUTO_INCREMENT,NAME VARCHAR(128));";
        try {
            statement.execute(SQL);
            //JavaSysMon javaSysMon;
            String SQLInsert = "insert into testone(NAME) VALUES ('Test'),('Tester'),('SMTH')";
            statement.execute(SQLInsert);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void querry(PrintWriter messageWriter) {
        String SQLget = "Select * from testone";
        try (ResultSet resultSet = statement.executeQuery(SQLget)) {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnsNumber = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) messageWriter.print(",  ");
                    String columnValue = resultSet.getString(i);
                    messageWriter.print(columnValue + " " + resultSetMetaData.getColumnName(i));
                }
                messageWriter.println("");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void close() {
        try {
            statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
