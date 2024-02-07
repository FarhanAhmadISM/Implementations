package com.learner;

import java.util.List;

public interface Database {
    void createTable(String tableName, List<Column> columns) throws Exception;
    void deleteTable(String tableName) throws Exception;
    void insertIntoTable(String tableName, Record record) throws Exception;
    List<Record> printAllRecordsOfTable(String tableName) throws Exception;
    void filteringOnTable(String tableName, String columnName, Object value) throws Exception;
}
