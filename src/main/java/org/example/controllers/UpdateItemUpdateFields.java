package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.App;
import org.example.DAO.hibernate.IItemDao;
import org.example.DAO.hibernate.ITypeDao;
import org.example.DAO.hibernate.ItemDao;
import org.example.DAO.hibernate.TypeDao;
import org.example.entity.Item;
import org.example.entity.Type;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class UpdateItemUpdateFields {
    private List<Type> tableList;

    private static String itemId;


    public static Item getItemToSend() {
        return itemToSend;
    }

    private static Item itemToSend;


    public static String getItemIdToSend() {
        return itemIdToSend;
    }

    @FXML
    private static String itemIdToSend;



    @FXML
    Label labelItemId;

    @FXML
    VBox vbox2;
    @FXML
    TextField fieldName;
    @FXML
    TextField fieldShelf;
    @FXML
    TextField fieldPhoto;
    @FXML
    TextField fieldSize;
    @FXML
    TextArea fieldDescription;

    Item itemToUpdate;



    public void initialize() throws ParserConfigurationException, IOException, SAXException {

        itemId = UpdateItemChooseItem.getItemId();
        labelItemId.setText(itemId);

        List<Item> items;

        IItemDao itemDao = new ItemDao();
        items = itemDao.getItemByItemId(itemId);

        itemToUpdate = items.get(0);

            fieldName.setText(itemToUpdate.getName());
            fieldPhoto.setText(itemToUpdate.getPhoto());
            fieldShelf.setText(itemToUpdate.getShellNumber());
            fieldSize.setText(itemToUpdate.getSize());
            fieldDescription.setText(itemToUpdate.getDescription());



    }

    @FXML
    public void toMainRiz(ActionEvent event) {
        try {
            App.setRoot("controllers/MainRiz_b");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toUpdateItemComplete() throws IOException {
        //------------Setting Listeners for textFields-------------------------


        itemToUpdate.setName(fieldName.getText());
        itemToUpdate.setPhoto(fieldPhoto.getText());
        itemToUpdate.setShellNumber(fieldShelf.getText());
        itemToUpdate.setSize(fieldSize.getText());
        itemToUpdate.setDescription(fieldDescription.getText());

        IItemDao itemDao = new ItemDao();
        itemDao.updateItem(itemToUpdate);



        //-------------------------------------------------------------------
        App.setRoot("controllers/updateItem/updateItemComplete");
    }

    @FXML
    public void toAdd1() throws IOException {
        App.setRoot("controllers/add1/add1_b");
    }
}
