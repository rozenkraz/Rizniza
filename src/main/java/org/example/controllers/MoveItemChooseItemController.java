package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.example.App;
import org.example.DAO.hibernate.IItemDao;
import org.example.DAO.hibernate.ITypeDao;
import org.example.DAO.hibernate.ItemDao;
import org.example.DAO.hibernate.TypeDao;
import org.example.entity.Item;
import org.example.entity.Type;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class MoveItemChooseItemController {
    private List<Item> listItems;

    @FXML
    StackPane stackPane;

    @FXML
    TableView<Item> tableView;

    @FXML
    Label label;

    @FXML
    TextField itemIdToSend;

    public static String getItemId() {
        return itemId;
    }

    private static String itemId;

    private String chosenTable;

    @FXML
    ChoiceBox<String> itemIdContainer;

    @FXML
    HBox hbox;

    public void initialize() throws ParserConfigurationException, IOException, SAXException {

        chosenTable = MoveItemChooseTableController.getTableName();
        label.setText("Список таблицы " + chosenTable + " готов!");

        IItemDao itemDao = new ItemDao();
        listItems = itemDao.getAllByPlace(chosenTable);




        TableColumn<Item, String> itemIdCol//
                = new TableColumn<Item, String>("Номер в каталоге");
        itemIdCol.setCellValueFactory(new PropertyValueFactory<>("itemId"));

        TableColumn<Item, String> nameCol//
                = new TableColumn<Item, String>("Название");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn<Item, String> photoCol//
                = new TableColumn<Item, String>("Фотогрфия");
        photoCol.setCellValueFactory(new PropertyValueFactory<>("photo"));



        try {
            ObservableList<Item> list = FXCollections.observableArrayList(listItems);
            tableView.setItems(list);
            tableView.getColumns().addAll(itemIdCol, nameCol, photoCol);


        }catch(Exception e){
            e.getMessage();
        }

        //------------Creating and filling choiceBox-------------------------


        String[] typeNames = new String[listItems.size()];
        int i = 0;

        for (Item item: listItems) {
            typeNames[i] = item.getItemId();
            i++;
        }



        ObservableList<String> types = FXCollections.observableArrayList(typeNames);
        itemIdContainer = new ChoiceBox<String>(types);
        itemIdContainer.setValue(typeNames[0]);
        hbox.getChildren().add(itemIdContainer);
    }

    @FXML
    public void toMainRiz(ActionEvent event) {
        try {
            App.setRoot("controllers/MainRiz_b");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toMoveItemChooseTable() throws IOException {
        App.setRoot("controllers/moveItem/moveItemChooseTable");
    }

    @FXML
    public void toMoveItemChooseDistination() throws IOException {
        itemId = itemIdContainer.getValue();

        App.setRoot("controllers/moveItem/moveItemChooseDistination");
    }


}
