package org.example.DAO;

import org.example.entity.ItemFromCollection1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemCollection1Dao implements IItemCollection1Dao{
    @Override
    public ItemFromCollection1 create(int id, String itemId, String size, String photo, String description, String currentPlace) {
        ItemFromCollection1 itemFromCollection1 = new ItemFromCollection1();
        itemFromCollection1.setId(id); ;
        itemFromCollection1.setItemId(itemId); ;
        itemFromCollection1.setSize(size); ;
        itemFromCollection1.setPhoto(photo); ;
        itemFromCollection1.setDescription(description); ;
        itemFromCollection1.setCurrentPlace(currentPlace); ;

        Connection connection = null;
        Statement statement = null;
        boolean rs;
        String query = "insert into itemcollection1 (itemId, size, photo, description, current_Place) values ('" + itemId + "', '" + size + "', '" + photo + "', '" + description + "', '" + currentPlace + "')";

        try
        {
            connection = getConnection();
            statement = connection.createStatement();
            rs = statement.execute(query);




        }catch (SQLException e){
            e.printStackTrace();
        }


        System.out.println(query);
        return itemFromCollection1;
    }

    @Override
    public ItemFromCollection1 read(int id) {
        return null;
    }

    @Override
    public void update(ItemFromCollection1 item) {

    }

    @Override
    public void delete(ItemFromCollection1 item) {

    }

    @Override
    public List<ItemFromCollection1> getAll(String tableName) {
        List<ItemFromCollection1> allItems = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        String query = "select * from itemcollection" + tableName;

        try
        {
            connection = getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                ItemFromCollection1 item = new ItemFromCollection1();

                item.setId(rs.getInt(1));
                item.setItemId(rs.getString(2));
                item.setSize(rs.getString(3));
                item.setPhoto(rs.getString(4));
                item.setCurrentPlace(rs.getString(6));
                item.setDescription(rs.getString(5));


                allItems.add(item);
                //System.out.println(item);
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
