package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        System.out.println("Привет");

        Item item = new Item();
        item.setId(121);
        item.setItemId("krest12");
        item.setSize("30x50");
        item.setPhoto("/dsfsadf/dsfasdfs.dfds");
        item.setDescription("It is very хорошее");
        item.setCurrentPlace("Ризница");
        item.setShellNumber("Номер 1 шкаф");
        item.setName("Крест серебрянный");

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();




        scene = new Scene(loadFXML("controllers/MainRiz_b"));

        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws SQLException {




        launch();
    }

}