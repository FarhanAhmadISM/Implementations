package org.example.Storage;
import org.example.Exception.NotFoundException;
import org.example.Exception.StorageFullException;

import java.util.HashMap;

public class HashMapBasedStorage<Key, Value> implements StorageInterface<Key, Value> {
    private final HashMap<Key, Value> storage;

    private final Integer capacity;
    public HashMapBasedStorage(Integer capacity) {
        this.storage = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void put(Key key, Value value) throws StorageFullException {
        if(isStorageFull()) {
            throw new StorageFullException("Storage is full !");
        }
        storage.remove(key);
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) {
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) throw new NotFoundException(key + "doesn't exist in cache.");
        return storage.get(key);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }
}
