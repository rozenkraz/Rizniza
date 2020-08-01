package org.example.DAO;

import org.example.entity.Item;
import org.example.entity.Place1Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Place1Dao implements IPlace1Dao{
    @Override
    public Place1Item add(int id, String itemId, String shellNumber) {
        Place1Item item = new Place1Item();
        item.setId(id);
        item.setItemId(itemId);
        item.setShellNumber(shellNumber);


        Connection connection = null;
        Statement statement = null;
        boolean rs;
        String query = "insert into place1 (itemId, shell_number) values ('" + itemId + "', '" + shellNumber + "')";

        try
        {
            connection = getConnection();
            statement = connection.createStatement();
            rs = statement.execute(query);




        }catch (SQLException e){
            e.printStackTrace();
        }


        System.out.println(query);
        return item;
    }

    @Override
    public Item read(String itemId) {
        return null;
    }

    @Override
    public void delete(String itemId){
        Connection connection = null;
        Statement statement = null;
        boolean rs;
        String query = "delete from place1 where itemid = '" + itemId + "'";

        try
        {
            connection = getConnection();
            statement = connection.createStatement();
            rs = statement.execute(query);




        }catch (SQLException e){
            e.printStackTrace();
        }


        System.out.println(query);
    }

    @Override
    public List<Place1Item> getAll(String tableName) {
        List<Place1Item> allItems = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        String query = "select  * from place" + tableName;

        try
        {
            connection = getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                Place1Item item = new Place1Item();

                item.setId(rs.getInt(1));
                item.setItemId(rs.getString(2));


                allItems.add(item);
                System.out.println(item);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }


        System.out.println(allItems);
        return allItems;
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

