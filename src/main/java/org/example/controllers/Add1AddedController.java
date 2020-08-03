package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.App;
import org.example.DAO.hibernate.IItemDao;
import org.example.DAO.hibernate.ItemDao;
import org.example.entity.Item;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Add1AddedController {

    Item item = Add1FieldsController.getItemToSend();

    public void initialize() throws ParserConfigurationException, IOException, SAXException {
        IItemDao itemDao = new ItemDao();
        itemDao.addItem(item);

    }


    @FXML
    public void toMainRiz(ActionEvent event) {
        try {
            App.setRoot("controllers/MainRiz_b");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
