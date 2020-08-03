package org.example.DAO.hibernate;

import org.example.entity.Item;

import java.util.List;

public interface IItemDao {
    Item addItem();
    void deleteItem();
    List<Item> getAll();
    Item getItemByItemId();
}
