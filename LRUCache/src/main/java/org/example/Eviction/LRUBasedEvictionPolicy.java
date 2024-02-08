package org.example.Eviction;

import org.example.DataStructure.DoubleLinkedList;
import org.example.DataStructure.DoubleLinkedListNode;

import java.util.HashMap;

public class LRUBasedEvictionPolicy<Key> implements EvictionPolicy<Key>{
    private final DoubleLinkedList<Key> dll;
    private final HashMap<Key, DoubleLinkedListNode<Key>> map;

    public LRUBasedEvictionPolicy() {
        this.dll = new DoubleLinkedList<>();
        this.map = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode<Key> doubleLinkedListNode = map.get(key);
            dll.deleteNode(doubleLinkedListNode);
            dll.addNodeAtLast(key);
        } else {
            DoubleLinkedListNode<Key> newNode = dll.addNodeAtLast(key);
            map.put(key, newNode);
        }
    }

    @Override
    public Key evictKey() {
        DoubleLinkedListNode<Key> node = dll.getFirstNode();
        dll.deleteNode(node);
        if (node != null) {
            map.remove(node.element);
        }
        return node == null ? null : node.element;
    }
}
