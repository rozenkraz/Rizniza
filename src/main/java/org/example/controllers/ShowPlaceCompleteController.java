package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import org.example.App;
import org.example.DAO.DaoFactory;
import org.example.DAO.IDaoFactory;
import org.example.DAO.IPlace1Dao;
import org.example.entity.Place1Item;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class ShowPlaceCompleteController {
    private List<Place1Item> listItems;

    @FXML
    StackPane stackPane;

    @FXML
    TableView<Place1Item> tableView;

    @FXML
    Label label;

    private String chosenTable;

    public void initialize() throws ParserConfigurationException, IOException, SAXException {

        chosenTable = ShowPlaceChoosePlaceController.getTableName();
        label.setText("Список таблицы " + chosenTable + " готов!");

        IDaoFactory factory = DaoFactory.getInstance();
        IPlace1Dao itemFromPlace1= factory.getPlace1();

        listItems = itemFromPlace1.getAll(chosenTable);




        TableColumn<Place1Item, String> itemIdCol//
                = new TableColumn<Place1Item, String>("Номер в каталоге");
        itemIdCol.setCellValueFactory(new PropertyValueFactory<>("itemId"));

        TableColumn<Place1Item, String> nameCol//
                = new TableColumn<Place1Item, String>("Название");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn<Place1Item, String> photoCol//
                = new TableColumn<Place1Item, String>("Фотогрфия");
        photoCol.setCellValueFactory(new PropertyValueFactory<>("photo"));



        try {
            ObservableList<Place1Item> list = FXCollections.observableArrayList(listItems);
            tableView.setItems(list);
            tableView.getColumns().addAll(itemIdCol, nameCol, photoCol);


        }catch(Exception e){
            e.getMessage();
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
}
