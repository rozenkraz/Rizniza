package org.example.DAO.hibernate;

import org.example.entity.Type;

import java.util.List;

public interface ITypeDao {
    Type addType(String typeName);
    void deleteType();
    List<Type> getAll();
}
