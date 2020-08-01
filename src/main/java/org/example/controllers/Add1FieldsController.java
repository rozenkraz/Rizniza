package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.App;

import java.io.IOException;

public class Add1FieldsController {


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
