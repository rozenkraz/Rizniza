package org.example.DAO;

import org.example.entity.ISTable;

import java.sql.SQLException;
import java.util.List;

public interface IISTablesDao {
    ISTable createPlaceTable(String tableName) throws SQLException;
    ISTable createItemCollectionTable(String tableName) throws SQLException;
    ISTable read(int id);
    void update(ISTable item);
    void dropTable(String tableName) throws SQLException;
    List<ISTable> getAllItemCollections();
    List<ISTable> getAllPLaces();
}
