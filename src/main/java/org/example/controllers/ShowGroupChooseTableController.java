package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import org.example.App;
import org.example.DAO.Base.DaoFactory;
import org.example.DAO.Base.IDaoFactory;
import org.example.DAO.Base.IISTablesDao;
import org.example.DAO.hibernate.IPlaceDao;
import org.example.DAO.hibernate.ITypeDao;
import org.example.DAO.hibernate.PlaceDao;
import org.example.DAO.hibernate.TypeDao;
import org.example.entity.ISTable;
import org.example.entity.Type;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class ShowGroupChooseTableController {

    private List<Type> tableList;

    public static String getTableName() {
        return tableName;
    }

    private static String tableName;


    private Type table1;

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
        ITypeDao typeDao = new TypeDao();

        tableList = typeDao.getAll();

        table1= tableList.get(0);

        ToggleGroup group = new ToggleGroup();



        for (Type type : tableList) {
            RadioButton radioButton = new RadioButton(type.getName());
            radioButton.setToggleGroup(group);
            radioButton.setOnAction(e -> {
                tableName = type.getName();
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
