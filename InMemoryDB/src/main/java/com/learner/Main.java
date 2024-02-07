package com.learner;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        InMemoryDB inMemoryDB = new InMemoryDB();

        List<Column> columns1 = Arrays.asList(
                new Column("id", DataType.Integer, true),
                new Column("name", DataType.String, true),
                new Column("age", DataType.Integer, false)
        );

        List<Column> columns2 = Arrays.asList(
                new Column("product_id", DataType.Integer, true),
                new Column("name", DataType.String, true),
                new Column("price", DataType.Integer, false),
                new Column("isSellable", DataType.Boolean, false)
        );

        try {
            inMemoryDB.createTable("users", columns1);
            inMemoryDB.createTable("products", columns2);
            inMemoryDB.printAllRecordsOfTable("users");
            inMemoryDB.printAllRecordsOfTable("products");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Record user1 = new Record();
        user1.setValues("id", 1);
        user1.setValues("name", "John");
        user1.setValues("age", 30);


        Record user2 = new Record();
        user2.setValues("id", 2);
        user2.setValues("name", "Alice");
        user2.setValues("age", 25);


        Record product1 = new Record();
        product1.setValues("product_id", 101);
        product1.setValues("name", "Laptop");
        product1.setValues("price", 1000);


        Record product2 = new Record();
        product2.setValues("product_id", 102);
        product2.setValues("name", "Smartphone");
        product2.setValues("price", 500);


        try {
            inMemoryDB.insertIntoTable("users", user1);
            inMemoryDB.insertIntoTable("users", user2);
            inMemoryDB.insertIntoTable("products", product1);
            inMemoryDB.insertIntoTable("products", product2);

            inMemoryDB.printAllRecordsOfTable("users");
            inMemoryDB.printAllRecordsOfTable("products");

            inMemoryDB.deleteTable("users");
            //inMemoryDB.printAllRecordsOfTable("users");

            inMemoryDB.filteringOnTable("products", "name", "Smartphone");
            inMemoryDB.printAllRecordsOfTable("products");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}