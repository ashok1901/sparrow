package com.sparrow.algoSolutions.basicDS;

import java.util.Iterator;

/**
 * Linked list implementation.
 * Caution: Not tested extensively.
 * 
 * @author Ashok 
 *
 * @param <T> : Data type of value in each link of the linked list
 */
public class CustomLinkedList<T> implements Iterable<T> 
{
    public static class Node<T>
    {
        private T value;
        private Node<T> next;

        public Node(T val) 
        {
            this.value = val;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void addHead(T value)
    {
        sanityCheck();
        Node<T> link = new Node<T>(value);
        if (head == null) {
            head = tail = link;
            return;
        }

        link.next = head;
        head = link;
    }

    private void sanityCheck()
    {
        if ((tail == null && head != null) ||
            (tail != null && head == null))
        {
            throw new RuntimeException("Inconsistent state");
        }
    }

    public void addTail(T value)
    {
        sanityCheck();
        Node<T> link = new Node<T>(value);
        if (tail == null && head == null) {
            head = tail = link;
            return;
        }

        tail.next = link;
        tail = link;
    }

    public T removeTail()
    {

        if (head == null) {
            return null;
        }

        Node<T> ptr = head;
        while(ptr.next != tail) {
            ptr = ptr.next;
        }

        T tailVal = tail.value;
        ptr.next = null;
        return tailVal;
    }

    public T removeHead()
    {
        if(head == null) {
            return null;
        }

        Node<T> headNode = head;
        head = head.next;
        headNode.next = null;
        if (head == null) {
            tail = null;
        }

        return headNode.value;
    }

    public T readHead()
    {
        return head != null ? head.value : null;
    }

    public T readTail()
    {
        return tail != null ? tail.value : null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        Node<T> ptr = head;
        while(ptr != null) {
            sb.append(ptr.value).append("->");
            ptr = ptr.getNext();
        }

        return sb.toString();
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
                Node<T> tmp = head;
            public boolean hasNext() {
                return tmp != null;
            }

            public T next() {
                T val = tmp.getValue();
                tmp = tmp.next;
                return val;
            }

            public void remove() {
                throw new UnsupportedOperationException("Remove on "
                        + " custom linked list iterator is not defined");
            }
        };
    }
}
