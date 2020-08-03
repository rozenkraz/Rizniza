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

    private static Item itemToSend;

    public static Item getItemToSend() {
        return itemToSend;
    }

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
        ChoiceBox<String> typeContainer = new ChoiceBox<String>(types);
        typeContainer.setValue(typeNames[0]);
        vbox2.getChildren().add(typeContainer);

        typeContainer.setOnAction(event -> itemToSend.setType(typeContainer.getValue()));
        //-------------------------------------------------------------------

        //------------Setting Listeners for textFields-------------------------

        fieldItemId.setOnAction(event -> itemToSend.setItemId(fieldItemId.getText()));
        fieldName.setOnAction(event -> itemToSend.setName(fieldName.getText()));
        fieldPhoto.setOnAction(event -> itemToSend.setPhoto(fieldPhoto.getText()));
        //itemToSend.setCurrentPlace(placeName);
        fieldShelf.setOnAction(event -> itemToSend.setShellNumber(fieldShelf.getText()));
        fieldSize.setOnAction(event -> itemToSend.setSize(fieldSize.getText()));
        fieldDescription.setOnKeyTyped(event -> itemToSend.setDescription(fieldDescription.getText()));



        //-------------------------------------------------------------------


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
        App.setRoot("controllers/add1/add1Added");
    }

    @FXML
    public void toAdd1() throws IOException {
        App.setRoot("controllers/add1/add1_b");
    }
}
