package com.javaseleniumtemplate.utils;

import java.sql.*;
import java.util.ArrayList;

public class DBUtils {

    public static ArrayList<String> getQueryResult(String query){
        ArrayList<String> arrayList = null;
        Connection connection = null;

        try {
            Class.forName("UTILIZAR O DRIVER DO BANCO DE DADOS DA APLICAÇÃO");
            Statement stmt = null;
            connection = DriverManager.getConnection("utilizar os parãmetros globais para montar a string de conexão de acordo com db utilizado");

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{
                int numberOfColumns;
                ResultSetMetaData metadata=null;

                arrayList = new ArrayList<String>();
                metadata = rs.getMetaData();
                numberOfColumns = metadata.getColumnCount();

                while (rs.next()) {
                    int i = 1;
                    while(i <= numberOfColumns) {
                        arrayList.add(rs.getString(i++));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
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
