package com.sparrow.algoSolutions.algos;

import com.sparrow.algoSolutions.basicDS.CustomStack;


public class ReverseStackInPlace {

    private static void reverseStackRecursive(CustomStack<String> s) {
        if (s.isEmpty()) {
            return;
        }

        String top = s.pop();
        reverseStackRecursive(s);
        stackBottomPush(s, top);
    }

    private static void stackBottomPush(CustomStack<String> s, String val) {
        if (s.isEmpty()) {
            s.push(val);
            return;
        }

        String top = s.pop();
        stackBottomPush(s, val);
        s.push(top);
    }

    public static void main(String[] args) 
    {
        CustomStack<String> s = new CustomStack<String>();
        s.push("Hello");
        s.push("I");
        s.push("Am");
        s.push("Here");

        System.out.println("Given Stack: " + s);
        reverseStackRecursive(s);
        System.out.println("Reversed Stack: " + s);
    }
}
