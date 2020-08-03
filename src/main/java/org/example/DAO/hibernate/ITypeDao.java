package org.example.DAO.hibernate;

import org.example.entity.Type;

import java.util.List;

public interface ITypeDao {
    Type addPlace();
    void deletePlace();
    List<Type> getAll();
}
