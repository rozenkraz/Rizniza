package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.App;

import java.io.IOException;

public class CreatePlaceTableCreatedController {
    @FXML
    private String name= CreatePlaceTableController.getTableCreatedName();

    @FXML
    private Label labelText;

    public void initialize() {
        labelText.setText("Таблица " + name + " создана успешно!");
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
