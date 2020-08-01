package org.example.DAO;

import org.example.entity.Item;
import org.example.entity.Place1Item;

import java.util.List;

public interface IPlace1Dao {

    Item add(int id, String itemId, String shellNumber);
    Item read(String itemId);
    void delete(String itemId);
    List<Place1Item> getAll(String tableName);

}
