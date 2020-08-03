package org.example.DAO.hibernate;

import org.example.entity.Item;

import java.util.List;

public interface IItemDao {
    Item addItem(Item item);
    void deleteItem();
    List<Item> getAll();
    Item getItemByItemId();
}
