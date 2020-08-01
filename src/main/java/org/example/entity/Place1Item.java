package org.example.entity;

public class Place1Item extends Item{

    private int id;



    private String name;
    private String photo;
    private String itemId;
    private String shellNumber;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

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

    public String getShellNumber() {
        return shellNumber;
    }

    public void setShellNumber(String shellNumber) {
        shellNumber = shellNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
