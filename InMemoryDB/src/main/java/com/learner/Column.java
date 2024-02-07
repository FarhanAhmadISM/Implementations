package com.learner;

public class Column {
    private String columnName;
    private DataType dataType;
    private boolean required;

    public Column(String columnName, DataType dataType, boolean required) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.required = required;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
