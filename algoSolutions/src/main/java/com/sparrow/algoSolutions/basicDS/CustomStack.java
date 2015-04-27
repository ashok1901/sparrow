package com.sparrow.algoSolutions.basicDS;

import java.util.Iterator;

/**
 * Stack implementation. This is just a wrapper around linked list.
 * 
 * @author Ashok
 */
public class CustomStack<T>
{
    private final int capacity;
    private final CustomLinkedList<T> stackData;
    private int size;

    public CustomStack() 
    {
        this(128);
    }

    public CustomStack(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.stackData = new CustomLinkedList<T>();
    }

    public boolean push(T val) {
        if(size == capacity) {
            // Overflow...
            return false;
        }

        stackData.addHead(val);
        size++;
        return true;
    }

    public T pop(){
        if (size == 0) {
            // Underflow...
            return null;
        }

        T val = stackData.removeHead();
        size--;
        return val;
    }

    public T seekTop() {
        if (size == 0) {
            // Underflow...
            return null;
        }

        return stackData.readHead();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("HEAD => ");
        Iterator<T> valItr = stackData.iterator();
        while(valItr.hasNext()) {
            sb.append("[").append(valItr.next()).append("] ");
        }

        return sb.toString();
    }
}
