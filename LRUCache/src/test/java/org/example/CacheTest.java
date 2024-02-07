package org.example;

import org.example.Eviction.LRUBasedEvictionPolicy;
import org.example.Storage.HashMapBasedStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CacheTest {

    Cache<Integer, Integer> cache;

    @BeforeEach
    void setUp() {
        HashMapBasedStorage<Integer, Integer> storageInterface = new HashMapBasedStorage<>(3);
        LRUBasedEvictionPolicy<Integer> lruBasedEvictionPolicy = new LRUBasedEvictionPolicy<>();
        cache = new Cache<>(storageInterface, lruBasedEvictionPolicy);
    }

    @Test
    void overallTest() {
        cache.put(1, 100);
        cache.put(2, 3);
        cache.put(3, 5);
        Assertions.assertEquals(100, cache.get(1));
        Assertions.assertEquals(3, cache.get(2));
        Assertions.assertEquals(5, cache.get(3));

        cache.put(3, 7);
        Assertions.assertEquals(7, cache.get(3));
        Assertions.assertNull(cache.get(1));
    }
}