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
        DoubleLinkedListNode<Key> doubleLinkedListNode = map.get(key);
        dll.deleteNode(doubleLinkedListNode);
        dll.addNodeAtLast(key);
    }

    @Override
    public Key evictKey() {
        DoubleLinkedListNode<Key> node = dll.getFirstNode();
        dll.deleteNode(node);
        return node == null ? null : node.element;
    }
}
