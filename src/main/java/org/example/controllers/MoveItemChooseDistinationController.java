package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.App;

import java.io.IOException;

public class MoveItemChooseDistinationController {
    @FXML
    public void toMainRiz(ActionEvent event) {
        try {
            App.setRoot("controllers/MainRiz_b");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toMoveItemComplete() throws IOException {
        App.setRoot("controllers/moveItem/moveItemComplete");
    }

    @FXML
    public void toMoveItemChooseItem() throws IOException {
        App.setRoot("controllers/moveItem/moveItemChooseItem");
    }
}
