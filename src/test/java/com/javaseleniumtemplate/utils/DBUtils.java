package com.javaseleniumtemplate.utils;

import com.javaseleniumtemplate.GlobalParameters;

import java.sql.*;
import java.util.ArrayList;

public class DBUtils {


    private static String getStringConnection() {
        return "jdbc:mysql://" +
                GlobalParameters.DB_URL
                + GlobalParameters.DB_DATABASE;
    }
    public static ArrayList<String> getQueryResult(String query) {
        ArrayList<String> arrayList = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = null;
            connection = DriverManager.getConnection(getStringConnection(), GlobalParameters.DB_USER, GlobalParameters.DB_PASSWORD);

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ExtentReportUtils.addTestInfo(3, query);
            if (!rs.isBeforeFirst()) {
                ExtentReportUtils.addTestInfo(3, "Resultado: null");
                return null;
            } else {
                int numberOfColumns;
                ResultSetMetaData metadata = null;

                arrayList = new ArrayList<String>();
                metadata = rs.getMetaData();
                numberOfColumns = metadata.getColumnCount();

                while (rs.next()) {
                    int i = 1;
                    while (i <= numberOfColumns) {
                        arrayList.add(rs.getString(i++));
                    }
                }
                ExtentReportUtils.addTestInfo(3, "Resultado: " + arrayList.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static void executeQuery(String query){
        Connection connection = null;

        try {
            Class.forName("UTILIZAR O DRIVER DO BANCO DE DADOS DA APLICAÇÃO");
            Statement stmt = null;
            connection = DriverManager.getConnection("utilizar os parãmetros globais para montar a string de conexão de acordo com db utilizado");

            stmt = connection.createStatement();
            stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
