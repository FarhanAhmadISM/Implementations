package com.learner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Table implements TableDao {

    String tableName;
    List<Record> records;
    List<Column> columns;

    public Table(List<Column> columns, String tableName) {
        this.columns = columns;
        this.tableName = tableName;
        records = new ArrayList<>();
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public void insertIntoTable(Record record) throws IllegalArgumentException {
        validateColumnValues(record);
        records.add(record);
    }

    @Override
    public List<Record> selectAllFromTable() {

        printResult(records);
        return records;
    }

    @Override
    public void getFilteredResultFromTable(String columnName, Object value) {
        List<Record> filteredRecords = new ArrayList<>();
        for (Record record : records) {
            Object columnValue = record.getValues().get(columnName);
            if (columnValue != null && columnValue.equals(value)) {
                filteredRecords.add(record);
            }
        }
        printResult(filteredRecords);
    }

    private void printResult(List<Record> records) {
        for (Record record : records) {
            for (Map.Entry<String, Object> map : record.getValues().entrySet()) {
                System.out.println("Column Name : " + map.getKey() + " :: value : " + map.getValue());
            }
        }
    }

    private void validateColumnValues(Record record) throws IllegalArgumentException {
        for (Column column : columns) {
            Object value = record.getValues().get(column.getColumnName());

            if (column.isRequired() && value == null) {
                throw new IllegalArgumentException("Value for column " + column.getColumnName() + " is required.");
            }

            if (value == null) {
                continue;
            }

            if (column.getDataType() == DataType.String && !(value instanceof String)) {
                throw new IllegalArgumentException("Invalid type for column " + column.getColumnName() + ". Expected String.");
            } else if (column.getDataType() == DataType.Integer && !(value instanceof Integer)) {
                throw new IllegalArgumentException("Invalid type for column " + column.getColumnName() + ". Expected Integer.");
            } else if (column.getDataType() == DataType.Boolean && !(value instanceof Boolean)) {
                throw new IllegalArgumentException("Invalid type for column " + column.getColumnName() + ". Expected Boolean.");
            }

            if (column.getDataType() == DataType.String && value.toString().length() > 20) {
                throw new IllegalArgumentException("Value for column " + column.getColumnName() + " exceeds maximum length.");
            } else if (column.getDataType() == DataType.Integer) {
                int intValue = (int) value;
                if (intValue < -1024 || intValue > 1024) {
                    throw new IllegalArgumentException("Value for column " + column.getColumnName() + " is out of range.");
                }
            }
        }
    }
}
