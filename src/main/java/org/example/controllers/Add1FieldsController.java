package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.example.App;
import org.example.DAO.hibernate.IPlaceDao;
import org.example.DAO.hibernate.ITypeDao;
import org.example.DAO.hibernate.PlaceDao;
import org.example.DAO.hibernate.TypeDao;
import org.example.entity.Item;
import org.example.entity.Place;
import org.example.entity.Type;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Add1FieldsController {


    private List<Type> tableList;


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
    Label labelTableName;

    @FXML
    VBox vbox2;

    @FXML
    TextField fieldName;

    @FXML
    TextField fieldShelf;

    @FXML
    TextField fieldPlace;

    @FXML
    TextField fieldPhoto;

    @FXML
    TextField fieldSize;

    @FXML
    TextField fieldItemId;

    @FXML
    TextArea fieldDescription;

    @FXML
    ChoiceBox<String> typeContainer;

    String placeName = Add1Controller.getTableName();

    public void initialize() throws ParserConfigurationException, IOException, SAXException {

        labelTableName.setText(placeName);
        //System.out.println(Add1Controller.getTableName());

        //------------Creating and filling choiceBox-------------------------
        ITypeDao typeDao = new TypeDao();

        tableList = typeDao.getAll();

        String[] typeNames = new String[tableList.size()];
        int i = 0;

        for (Type type : tableList) {
            typeNames[i] = type.getName();
            i++;
        }



        ObservableList<String> types = FXCollections.observableArrayList(typeNames);
        typeContainer = new ChoiceBox<String>(types);
        typeContainer.setValue(typeNames[0]);
        vbox2.getChildren().add(typeContainer);






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
    public void toAdd1Added() throws IOException {
        //------------Setting Listeners for textFields-------------------------
        itemToSend = new Item();

        itemToSend.setItemId(fieldItemId.getText());
       itemToSend.setName(fieldName.getText());
       itemToSend.setPhoto(fieldPhoto.getText());

        itemToSend.setType(typeContainer.getValue());
        itemToSend.setCurrentPlace(placeName);

        itemToSend.setShellNumber(fieldShelf.getText());
        itemToSend.setSize(fieldSize.getText());
        itemToSend.setDescription(fieldDescription.getText());



        //-------------------------------------------------------------------
        App.setRoot("controllers/add1/add1Added");
    }

    @FXML
    public void toAdd1() throws IOException {
        App.setRoot("controllers/add1/add1_b");
    }
}
