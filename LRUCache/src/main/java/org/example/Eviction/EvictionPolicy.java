package org.example.Eviction;

import org.example.DataStructure.DoubleLinkedListNode;

public interface EvictionPolicy<Key> {
    void keyAccessed(Key key);
    Key evictKey();
}
