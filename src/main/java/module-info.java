module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example to javafx.fxml;
    opens org.example.controllers to javafx.fxml;
    opens org.example.entity to javafx.base;

    exports org.example;
}