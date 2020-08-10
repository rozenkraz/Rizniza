package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import org.example.App;
import org.example.DAO.Base.DaoFactory;
import org.example.DAO.Base.IDaoFactory;
import org.example.DAO.Base.IPlace1Dao;
import org.example.DAO.hibernate.IItemDao;
import org.example.DAO.hibernate.IPlaceDao;
import org.example.DAO.hibernate.ItemDao;
import org.example.DAO.hibernate.PlaceDao;
import org.example.entity.Item;
import org.example.entity.Place1Item;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ShowPlaceCompleteController {
    private List<Item> listItems;

    @FXML
    StackPane stackPane;

    @FXML
    TableView<Item> tableView;

    @FXML
    Label label;

    private String chosenTable;

    public void initialize() throws ParserConfigurationException, IOException, SAXException {

        chosenTable = ShowPlaceChoosePlaceController.getTableName();
        label.setText("Список таблицы " + chosenTable + " готов!");

        IItemDao itemDao = new ItemDao();
        listItems = itemDao.getAllByPlace(chosenTable);

        for (Item item : listItems) {
            System.out.println(item.getPhoto());
            item.image = new ImageView(new Image(new FileInputStream(item.getPhoto())));
            item.image.setFitHeight(150);
            item.image.setPreserveRatio(true);
        }




        TableColumn<Item, String> itemIdCol//
                = new TableColumn<Item, String>("Номер Каталога");
        itemIdCol.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        itemIdCol.setStyle( "-fx-alignment: CENTER-LEFT;");


        TableColumn<Item, String> nameCol//
                = new TableColumn<Item, String>("Название");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setStyle( "-fx-alignment: CENTER-LEFT;");

        TableColumn<Item, String> photoCol//
                = new TableColumn<Item, String>("Фото");
        photoCol.setCellValueFactory(new PropertyValueFactory<>("photo"));
        photoCol.setStyle( "-fx-alignment: CENTER-LEFT;");

        /* initialize and specify table column */
        TableColumn<Item, ImageView> imgCol = new TableColumn<Item, ImageView>("Images");
        imgCol.setCellValueFactory(new PropertyValueFactory<Item, ImageView>("image"));
        imgCol.setStyle( "-fx-alignment: CENTER-LEFT;");



        try {
            ObservableList<Item> list = FXCollections.observableArrayList(listItems);
            tableView.setItems(list);
            tableView.getColumns().addAll(itemIdCol, nameCol, photoCol, imgCol);




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
