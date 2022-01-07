package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import org.example.App;
import org.example.DAO.hibernate.IPlaceDao;
import org.example.DAO.hibernate.PlaceDao;
import org.example.entity.Place;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class UpdateItemChoosePlace {
    private List<Place> tableList;

    private Place table1;

    public static String getTableName() {
        return tableName;
    }

    private static String tableName;

    @FXML
    VBox container;

    public void initialize() throws ParserConfigurationException, IOException, SAXException {
        IPlaceDao placeDao = new PlaceDao();

        tableList = placeDao.getAll();

        table1= tableList.get(0);

        ToggleGroup group = new ToggleGroup();



        for (Place place : tableList) {
            RadioButton radioButton = new RadioButton(place.getName());
            radioButton.setToggleGroup(group);
            radioButton.setOnAction(e -> {
                tableName = place.getName();
            });;

            container.getChildren().add(radioButton);
        }



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
    public void toUpdateItemChooseItem() throws IOException {

        try {
            App.setRoot("controllers/updateItem/updateItemChooseItem");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}