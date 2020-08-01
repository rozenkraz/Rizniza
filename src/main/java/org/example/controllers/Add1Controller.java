package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class Add1Controller {

    private List<ISTable> tableList;

    private ISTable table1;

    public static String getTableName() {
        return tableName;
    }

    private static String tableName;

    @FXML
    VBox container;


    public void initialize() throws ParserConfigurationException, IOException, SAXException {
        IDaoFactory factory = DaoFactory.getInstance();
        IISTablesDao isTablesDao = factory.getISTable();

        ISTable newTable = new ISTable();

        tableList = isTablesDao.getAllPLaces();

        table1 = tableList.get(0);
        tableName = table1.getTableName().substring(5);

        ToggleGroup group = new ToggleGroup();


        for (ISTable istable : tableList) {
            RadioButton radioButton = new RadioButton(istable.getTableName().substring(5));
            radioButton.setToggleGroup(group);
            radioButton.setOnAction(e -> {
                tableName = istable.getTableName().substring(5);
            });
            ;

            container.getChildren().add(radioButton);
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

    @FXML
    public void toAdd1Fields() throws IOException {
        App.setRoot("controllers/add1/add1Fields");
    }
}
