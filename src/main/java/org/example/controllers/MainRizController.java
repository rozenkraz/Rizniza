package org.example.controllers;

import javafx.fxml.FXML;
import org.example.App;

import java.io.IOException;

public class MainRizController {

    @FXML
    public void toAdd1() throws IOException {
        App.setRoot("controllers/add1/add1_b");
    }

    @FXML
    public void toCreatePlaceTable() throws IOException {
        App.setRoot("controllers/createPlaceTable/createTable");
    }

    @FXML
    public void toCreateItemCollectionTable() throws IOException {
        App.setRoot("controllers/createItemCollectionTable/createTable");
    }

    @FXML
    public void toMoveItemChooseTable() throws IOException {
        App.setRoot("controllers/moveItem/moveItemChooseTable");
    }

    @FXML
    public void toShowGroupChooseTable() throws IOException {
        App.setRoot("controllers/showGroup/showGroupChooseTable");
    }
    @FXML
    public void toShowPlaceChoosePlace() throws IOException {
        App.setRoot("controllers/showPlace/showPlaceChoosePlace");
    }
}
