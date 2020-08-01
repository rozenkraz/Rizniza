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
import org.example.DAO.IItemCollection1Dao;
import org.example.entity.ItemFromCollection1;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class ShowGroupCompleteController {

    private List<ItemFromCollection1> listItems;

    @FXML
    Label label2;

    @FXML
    StackPane stackPane;

    @FXML
    TableView<ItemFromCollection1> tableView;

    @FXML
    Label label;

    private String chosenTable;
    @FXML
    public void toMainRiz(ActionEvent event) {
        try {
            App.setRoot("controllers/MainRiz_b");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() throws ParserConfigurationException, IOException, SAXException {

        chosenTable = ShowGroupChooseTableController.getTableName();
        label.setText("Список таблицы " + chosenTable + " готов!");

        IDaoFactory factory = DaoFactory.getInstance();
        IItemCollection1Dao itemFromCollection1= factory.getItemFromCollection1();

        listItems = itemFromCollection1.getAll(chosenTable);


        TableColumn<ItemFromCollection1, String> photoCol//
                = new TableColumn<ItemFromCollection1, String>("Фото");
        photoCol.setCellValueFactory(new PropertyValueFactory<>("photo"));

        TableColumn<ItemFromCollection1, String> itemIdCol//
                = new TableColumn<ItemFromCollection1, String>("Номер Каталога");
        itemIdCol.setCellValueFactory(new PropertyValueFactory<>("itemId"));

        TableColumn<ItemFromCollection1, String> sizeCol//
                = new TableColumn<ItemFromCollection1, String>("Размер");
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));

        TableColumn<ItemFromCollection1, String> descriptionCol//
                = new TableColumn<ItemFromCollection1, String>("Описание");
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<ItemFromCollection1, String> placeCol//
                = new TableColumn<ItemFromCollection1, String>("Текущее место");
        placeCol.setCellValueFactory(new PropertyValueFactory<>("currentPlace"));

        TableColumn<ItemFromCollection1, String> nameCol//
                = new TableColumn<ItemFromCollection1, String>("Название");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        try {
            ObservableList<ItemFromCollection1> list = FXCollections.observableArrayList(listItems);
            tableView.setItems(list);
            tableView.getColumns().addAll(photoCol, itemIdCol, sizeCol, descriptionCol, placeCol, nameCol);


        }catch(Exception e){
            e.getMessage();
        }

    }



}
