package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.DAO.Base.DaoFactory;
import org.example.DAO.Base.IDaoFactory;
import org.example.DAO.Base.IISTablesDao;
import org.example.DAO.hibernate.PlaceDao;
import org.example.DAO.hibernate.TypeDao;
import org.example.entity.ISTable;

import java.io.IOException;
import java.sql.SQLException;

public class CreateItemCollectionTableController {


    @FXML
    private TextField createTableName;

    public static String getTableCreatedName() {
        return tableCreatedName;
    }


    private static String tableCreatedName;


    @FXML
    public void toMainRiz(ActionEvent event) {
        try {
            App.setRoot("controllers/MainRiz_b");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void toCreatedTableCreated(ActionEvent event) throws SQLException, IOException {


        tableCreatedName = createTableName.getText();
        //System.out.println(tableCreatedName);

        /*IDaoFactory factory = DaoFactory.getInstance();
        IISTablesDao isTablesDao = factory.getISTable();

        ISTable newTable = new ISTable();*/
        if((tableCreatedName != "") && (tableCreatedName.length() < 230)) {
           /* newTable.setTableName(tableCreatedName);

            isTablesDao.createItemCollectionTable(newTable.getTableName());*/

            TypeDao typeDao = new TypeDao();
            typeDao.addType(tableCreatedName);
        }
        App.setRoot("controllers/createItemCollectionTable/createTableCreated");

    }
}
