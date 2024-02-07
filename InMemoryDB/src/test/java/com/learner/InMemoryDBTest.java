package com.learner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class InMemoryDBTest {

    InMemoryDB inMemoryDB;
    Table table1;
    Table table2;

    @BeforeEach
    void setUp() {
        inMemoryDB = new InMemoryDB();
        List<Column> columns = new ArrayList<>();
        Column column = new Column("Name", DataType.String, true);
        columns.add(column);
        table1 = new Table(columns, "TABLE1");
        table2 = new Table(columns, "TABLE2");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createTable() throws Exception {
        inMemoryDB.createTable(table1.tableName, table1.columns);
        inMemoryDB.createTable(table2.tableName, table2.columns);
        Assertions.assertEquals(inMemoryDB.getTables().size(), 2);
    }

    @Test
    void deleteTable() throws Exception {
        inMemoryDB.createTable(table1.tableName, table1.columns);
        inMemoryDB.deleteTable(table1.tableName);
        Assertions.assertEquals(inMemoryDB.getTables().size(), 0);
    }

    @Test
    void insertIntoTable() {

    }

    @Test
    void printAllRecordsOfTable() {
    }

    @Test
    void filteringOnTable() {
    }
}