package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.example.App;
import org.example.DAO.hibernate.IItemDao;
import org.example.DAO.hibernate.ItemDao;
import org.example.entity.Item;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class UpdateItemChooseItem {
    private List<Item> listItems;

    @FXML
    StackPane stackPane1;

    @FXML
    TableView<Item> tableView;

    @FXML
    Label label1;

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

        chosenTable = UpdateItemChoosePlace.getTableName();
        label1.setText("Список таблицы " + chosenTable + " готов!");

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


        String[] itemIdValues = new String[listItems.size()];
        int i = 0;

        for (Item item: listItems) {
            itemIdValues[i] = item.getItemId();
            i++;
        }



        ObservableList<String> itemIds = FXCollections.observableArrayList(itemIdValues);
        itemIdContainer = new ChoiceBox<String>(itemIds);

        itemIdContainer.setValue(itemIdValues[0]);
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
    public void toUpdateItemChoosePlace() throws IOException {
        App.setRoot("controllers/updateItem/updateItemChoosePlace");
    }

    @FXML
    public void toUpdateItemFillFields() throws IOException {
        //System.out.println(itemIdContainer.getValue());
        itemId = itemIdContainer.getValue();

        App.setRoot("controllers/updateItem/updateItemFillFields");
    }

}
