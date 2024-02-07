package org.example.DataStructure;

public class DoubleLinkedList<Element> {
    private final DoubleLinkedListNode<Element> dummyHead;
    private final DoubleLinkedListNode<Element> dummyTail;


    public DoubleLinkedList() {
        this.dummyHead = new DoubleLinkedListNode<>(null);
        this.dummyTail = new DoubleLinkedListNode<>(null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void deleteNode(DoubleLinkedListNode<Element> node) {
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtLast(Element key) {
        if(key != null) {
            DoubleLinkedListNode<Element> newNode = new DoubleLinkedListNode<>(key);
            DoubleLinkedListNode<Element> tailPrev = dummyTail.prev;

            dummyTail.prev.next = newNode;
            newNode.next = dummyTail;
            dummyTail.prev = newNode;
            newNode.prev = tailPrev;
        }
    }

    public DoubleLinkedListNode<Element> getFirstNode() {
        if (dummyHead.next != dummyTail) {
            return dummyHead.next;
        }
        return null;
    }

    public DoubleLinkedListNode<Element> getLastNode() {
        if (dummyTail.prev != dummyHead) {
            return dummyTail.prev;
        }
        return null;
    }
}
