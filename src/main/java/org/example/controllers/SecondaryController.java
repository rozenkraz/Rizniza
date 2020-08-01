package org.example.controllers;

import javafx.fxml.FXML;
import org.example.App;

import java.io.IOException;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("controllers/primary");
    }
}