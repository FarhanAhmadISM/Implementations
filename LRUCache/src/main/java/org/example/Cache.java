package org.example;

import org.example.Eviction.EvictionPolicy;
import org.example.Exception.NotFoundException;
import org.example.Exception.StorageFullException;
import org.example.Storage.StorageInterface;

public class Cache<Key, Value> {
    private final StorageInterface<Key, Value> storageInterface;
    private final EvictionPolicy<Key> evictionPolicy;


    public Cache(StorageInterface<Key, Value> storageInterface, EvictionPolicy<Key> evictionPolicy) {
        this.storageInterface = storageInterface;
        this.evictionPolicy = evictionPolicy;
    }

    void put(Key key, Value value) {
        try {
            storageInterface.put(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            System.out.println(e.getMessage());
            Key keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }
            storageInterface.remove(keyToRemove);
            System.out.println("Creating space by evicting item..." + keyToRemove);
            put(key, value);
        }
    }

    Value get(Key key) {
        try {
            Value value = storageInterface.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException notFoundException) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
}
