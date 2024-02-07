package org.example.Storage;
import org.example.Exception.NotFoundException;
import org.example.Exception.StorageFullException;

public interface StorageInterface<Key, Value>{
    void put(Key key, Value value) throws StorageFullException;
    void remove(Key key);
    Value get(Key key) throws NotFoundException;
}
