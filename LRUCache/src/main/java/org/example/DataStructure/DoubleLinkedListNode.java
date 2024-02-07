package org.example.DataStructure;

public class DoubleLinkedListNode<Element>{
    public DoubleLinkedListNode<Element> next;
    public DoubleLinkedListNode<Element> prev;
    public Element element;

    public DoubleLinkedListNode(Element element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
