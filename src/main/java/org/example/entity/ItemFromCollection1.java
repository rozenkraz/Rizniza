package org.example.entity;

public class ItemFromCollection1 extends Item {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String itemId;
    private String size;
    private String photo;
    private String description;
    private String currentPlace;

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

    @Override
    public String toString() {
        return "ItemFromCollection1{" +
                "id=" + id +
                ", itemId='" + itemId + '\'' +
                ", size='" + size + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", currentPlace='" + currentPlace + '\'' +
                '}';
    }
}
