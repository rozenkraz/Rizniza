package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import org.example.App;
import org.example.DAO.DaoFactory;
import org.example.DAO.IDaoFactory;
import org.example.DAO.IISTablesDao;
import org.example.entity.ISTable;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class ShowGroupChooseTableController {

    private List<ISTable> tableList;

    public static String getTableName() {
        return tableName;
    }

    private static String tableName;


    private ISTable table1;

    @FXML
    VBox container;

    @FXML
    Label label;

    @FXML
    RadioButton b1;

    @FXML
    RadioButton b2;

    @FXML
    RadioButton b3;

    @FXML
    RadioButton b4;

    @FXML
    public void toMainRiz(ActionEvent event) {
        try {
            App.setRoot("controllers/MainRiz_b");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() throws ParserConfigurationException, IOException, SAXException {
        IDaoFactory factory = DaoFactory.getInstance();
        IISTablesDao isTablesDao = factory.getISTable();

        ISTable newTable = new ISTable();

        tableList = isTablesDao.getAllItemCollections();

        table1= tableList.get(0);
        tableName = table1.getTableName().substring(14);

        ToggleGroup group = new ToggleGroup();



        for (ISTable istable : tableList) {
            RadioButton radioButton = new RadioButton(istable.getTableName().substring(14));
            radioButton.setToggleGroup(group);
            radioButton.setOnAction(e -> {
                tableName = istable.getTableName().substring(14);
            });;

            container.getChildren().add(radioButton);
        }



    }

    @FXML
    private void marked(){

    }

    @FXML
    public void toShowGroupComplete() throws IOException {
        App.setRoot("controllers/showGroup/showGroupComplete");
    }

}
