package com.learner;


import java.util.HashMap;
import java.util.List;

public class InMemoryDB implements Database {

    private final HashMap<String, Table> tables;

    public InMemoryDB() {
        this.tables = new HashMap<>();
    }

    public HashMap<String, Table> getTables() {
        return tables;
    }
    @Override
    public void createTable(String tableName, List<Column> columns) throws Exception {
        if (tables.containsKey(tableName)) {
            throw new Exception("Table already exists");
        }
        Table table = new Table(columns, tableName);
        tables.put(tableName, table);
        System.out.println("Table : " + tableName + " created successfully");
    }

    @Override
    public void deleteTable(String tableName) throws Exception {
        if (!tables.containsKey(tableName)) {
            throw new Exception("Table doesn't exist");
        }
        tables.remove(tableName);
        System.out.println("Table : " + tableName + " removed successfully");
    }

    @Override
    public void insertIntoTable(String tableName, Record record) throws Exception {
        if (!tables.containsKey(tableName)) {
            throw new Exception("Table doesn't exist");
        }
        Table table = tables.get(tableName);
        table.insertIntoTable(record);
        System.out.println("Entry added in table : " + tableName + " successfully");
    }

    @Override
    public List<Record> printAllRecordsOfTable(String tableName) throws Exception {
        if (!tables.containsKey(tableName)) {
            throw new Exception("Table doesn't exist");
        }
        Table table = tables.get(tableName);
        return table.selectAllFromTable();
    }

    @Override
    public void filteringOnTable(String tableName, String columnName, Object value) throws Exception {
        if (!tables.containsKey(tableName)) {
            throw new Exception("Table doesn't exist");
        }
        Table table = tables.get(tableName);
        table.getFilteredResultFromTable(columnName, value);
    }

}
