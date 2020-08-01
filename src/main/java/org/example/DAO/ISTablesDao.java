package org.example.DAO;

import org.example.entity.ISTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ISTablesDao implements  IISTablesDao{


    @Override
    public ISTable createPlaceTable(String tableName) throws SQLException {

        Connection connection = null;
        connection = getConnection();
        String query = "create table place" + tableName + " (ID INT, NAME VARCHAR2(255), ITEMID VARCHAR2(255), PHOTO VARCHAR2(255), SHELL_NUMBER VARCHAR2(255))";

        Statement statement = connection.createStatement();


        boolean rs = statement.execute(query);

        return null;
    }

    @Override
    public ISTable createItemCollectionTable(String tableName) throws SQLException {
        Connection connection = null;
        connection = getConnection();
        String query = "create table itemcollection" + tableName + " (ID INT, NAME VARCHAR2(255), ITEMID  VARCHAR2(255), size VARCHAR2(255), photo VARCHAR2(255), description VARCHAR2(2550), current_place VARCHAR2(255))";

        Statement statement = connection.createStatement();


        boolean rs = statement.execute(query);

        return null;
    }

    @Override
    public ISTable read(int id) {
        return null;
    }

    @Override
    public void update(ISTable item) {

    }

    @Override
    public void dropTable(String tableName) throws SQLException {
        Connection connection = null;
        connection = getConnection();
        String query = "drop table " + tableName;

        Statement statement = connection.createStatement();


        boolean rs = statement.execute(query);

    }

    @Override
    public List<ISTable> getAllItemCollections() {
        List<ISTable> allTables = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        String query = "select  table_name from INFORMATION_SCHEMA.TABLES where TABLE_NAME like 'ITEM%'";

        try
        {
            connection = getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                ISTable table = new ISTable();

                table.setTableName(rs.getString("table_name"));
                allTables.add(table);
                //System.out.println(table.getTableName());
            }


        }catch (SQLException e){
            e.printStackTrace();
        }


        //System.out.println(allTables);
        return allTables;
    }

    @Override
    public List<ISTable> getAllPLaces() {
        List<ISTable> allTables = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        String query = "select  table_name from INFORMATION_SCHEMA.TABLES where TABLE_NAME like 'PLACE%'";

        try
        {
            connection = getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                ISTable table = new ISTable();

                table.setTableName(rs.getString("table_name"));
                allTables.add(table);
                //System.out.println(table.getTableName());
            }


        }catch (SQLException e){
            e.printStackTrace();
        }


        //System.out.println(allTables);
        return allTables;
    }

    private Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:h2:file://home/j/IdeaProjects/niki.org/Rizniza/db/db";
        String userName = "user";
        String pass = "password";

        try {
            connection = DriverManager.getConnection(url, userName, pass);
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
