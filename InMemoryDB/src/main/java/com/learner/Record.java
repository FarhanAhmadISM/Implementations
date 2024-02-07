package com.learner;

import java.util.HashMap;

public class Record {
    private HashMap<String, Object> values;

    public Record() {
        this.values = new HashMap<>();
    }

    public HashMap<String, Object> getValues() {
        return values;
    }

    public void setValues(String key, Object values) {
        this.values.put(key, values);
    }
}
