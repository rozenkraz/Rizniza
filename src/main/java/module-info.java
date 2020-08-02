module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;

    opens org.example;
    opens org.example.controllers to javafx.fxml;
    opens org.example.entity;

    exports org.example;
}