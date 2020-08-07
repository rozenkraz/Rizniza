package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String itemId;
    private String size;
    private String photo;
    private String description;
    private String type;
    private String currentPlace;
    private String shellNumber;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(String currentPlace) {
        this.currentPlace = currentPlace;
    }

    public String getShellNumber() {
        return shellNumber;
    }

    public void setShellNumber(String shellNumber) {
        this.shellNumber = shellNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemId='" + itemId + '\'' +
                ", size='" + size + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", currentPlace='" + currentPlace + '\'' +
                ", shellNumber='" + shellNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
