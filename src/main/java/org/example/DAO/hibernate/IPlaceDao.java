package org.example.DAO.hibernate;

import org.example.entity.Place;
import org.example.entity.Place1Item;

import java.util.List;

public interface IPlaceDao {
    Place addPlace(String tableName);
    void deletePlace();
    List<Place> getAll();
}
