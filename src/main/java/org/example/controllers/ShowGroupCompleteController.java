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
import org.example.DAO.Base.DaoFactory;
import org.example.DAO.Base.IDaoFactory;
import org.example.DAO.Base.IItemCollection1Dao;
import org.example.DAO.hibernate.IItemDao;
import org.example.DAO.hibernate.ItemDao;
import org.example.entity.Item;
import org.example.entity.ItemFromCollection1;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class ShowGroupCompleteController {

    private List<Item> listItems;

    @FXML
    Label label2;

    @FXML
    StackPane stackPane;

    @FXML
    TableView<Item> tableView;

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

        IItemDao itemDao = new ItemDao();

        listItems = itemDao.getAllByType(chosenTable);

        TableColumn<Item, String> photoCol//
                = new TableColumn<Item, String>("Фото");
        photoCol.setCellValueFactory(new PropertyValueFactory<>("photo"));

        TableColumn<Item, String> itemIdCol//
                = new TableColumn<Item, String>("Номер Каталога");
        itemIdCol.setCellValueFactory(new PropertyValueFactory<>("itemId"));

        TableColumn<Item, String> sizeCol//
                = new TableColumn<Item, String>("Размер");
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));

        TableColumn<Item, String> descriptionCol//
                = new TableColumn<Item, String>("Описание");
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Item, String> placeCol//
                = new TableColumn<Item, String>("Текущее место");
        placeCol.setCellValueFactory(new PropertyValueFactory<>("currentPlace"));

        TableColumn<Item, String> nameCol//
                = new TableColumn<Item, String>("Название");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        try {
            ObservableList<Item> list = FXCollections.observableArrayList(listItems);
            tableView.setItems(list);
            tableView.getColumns().addAll(photoCol, itemIdCol, sizeCol, descriptionCol, placeCol, nameCol);


        }catch(Exception e){
            e.getMessage();
        }

    }



}
