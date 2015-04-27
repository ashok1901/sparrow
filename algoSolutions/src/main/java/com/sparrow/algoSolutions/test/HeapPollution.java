package com.sparrow.algoSolutions.test;

import java.util.ArrayList;
import java.util.List;

public class HeapPollution 
{
    public static void main(String[] args) 
    {
        List a = new ArrayList<String>();
        a.add("abc");

        Double d = new Double(12.2);
        a.add(d);
    }
}
