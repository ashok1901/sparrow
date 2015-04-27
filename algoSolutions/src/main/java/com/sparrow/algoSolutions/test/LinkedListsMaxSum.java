package com.sparrow.algoSolutions.test;

import com.sparrow.algoSolutions.basicDS.CustomLinkedList;
import com.sparrow.algoSolutions.basicDS.CustomLinkedList.Node;

public class LinkedListsMaxSum 
{
    private static int deriveMaxSum(Node<Integer> first, 
                                    Node<Integer> second)
    {
        int firstSum = 0, secondSum = 0;
        Node<Integer> firstPtr = first;
        Node<Integer> secondPtr = second;

        while(firstPtr != null && secondPtr != null &&
              firstPtr.getValue() != secondPtr.getValue()) 
        {
            if (firstPtr.getValue() < secondPtr.getValue()) {
                firstSum += firstPtr.getValue();
                firstPtr = firstPtr.getNext();
            } else {
                secondSum += secondPtr.getValue();
                secondPtr = secondPtr.getNext();
            }
        } 

        if (firstPtr == null) {
            while(secondPtr != null) {
                secondSum+=secondPtr.getValue();
                secondPtr = secondPtr.getNext();
            }
        }

        if (secondPtr == null) {
            while(firstPtr != null) {
                firstSum+=firstPtr.getValue();
                firstPtr = firstPtr.getNext();
            }
        }

        if (firstPtr == null && secondPtr == null) {
            return firstSum > secondSum ? firstSum : secondSum;
        }

        int commonValue = 0;
        if (firstPtr != null && secondPtr != null) {
            commonValue = firstPtr.getValue();
            firstPtr = firstPtr.getNext();
            secondPtr = secondPtr.getNext();
        }

        return firstSum > secondSum
                ? firstSum + commonValue + deriveMaxSum(firstPtr, secondPtr)
                : secondSum + commonValue + deriveMaxSum(firstPtr, secondPtr);
    }

    public static void main(String[] args) 
    {
        CustomLinkedList<Integer> firstList = new CustomLinkedList<Integer>();
        firstList.addTail(2);
        firstList.addTail(3);
        firstList.addTail(4);
        firstList.addTail(5);
        firstList.addTail(6);
        firstList.addTail(7);
        firstList.addTail(8);

        CustomLinkedList<Integer> secondList = new CustomLinkedList<Integer>();
        secondList.addTail(1);
        secondList.addTail(2);
        secondList.addTail(5);
        secondList.addTail(9);
        secondList.addTail(10);

        System.out.println(firstList);
        System.out.println(secondList);
        System.out.println(deriveMaxSum(firstList.getHead(), secondList.getHead()));
    }
}
