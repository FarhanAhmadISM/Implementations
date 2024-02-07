package com.learner;

import java.util.List;

public interface TableDao {
    void insertIntoTable(Record record) throws IllegalArgumentException;
    List<Record> selectAllFromTable();
    void getFilteredResultFromTable(String columnName, Object value);
}
