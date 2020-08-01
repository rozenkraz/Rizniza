package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.App;

import java.io.IOException;

public class MoveItemComplete {
    @FXML
    public void toMainRiz(ActionEvent event) {
        try {
            App.setRoot("controllers/MainRiz_b");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
