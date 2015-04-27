package com.sparrow.algoSolutions.algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DigitsCombinations {

    private static int comb(int prevDigit, Map<Integer, Integer> dataSet,
            int length, int numSoFar, Set<Integer> allNumbers) {
        int sum = 0;
        if (length == 1) {
            for (Entry<Integer, Integer> e : dataSet.entrySet()) {
                int digit = e.getKey();
                int count = e.getValue();
                if (count == 0 || digit == prevDigit) {
                    continue;
                }
                int num = numSoFar * 10 + digit;
                if (allNumbers.contains(num)) {
                    System.out.println("DUPLICATE " + num);
                    throw new RuntimeException("DUPLICATE " + num);
                } else {
                    allNumbers.add(num);
                    // System.out.println(numSoFar*10 + digit);
                }

                sum += 1;
            }

            return sum;
        }

        // Each recursive call gives numbers starting with "digit"
        for (Entry<Integer, Integer> e : dataSet.entrySet()) {
            int digit = e.getKey();
            int count = e.getValue();
            if (count == 0 || digit == prevDigit) {
                continue;
            }

            dataSet.put(digit, --count);
            sum += comb(digit, dataSet, length - 1, numSoFar * 10 + digit,
                    allNumbers);
            dataSet.put(digit, ++count);
        }

        return sum;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> dataSet = new HashMap<Integer, Integer>();
        dataSet.put(1, 1);
        dataSet.put(2, 1);
        dataSet.put(3, 1);
        dataSet.put(4, 2);
        int count = 0;
        for (int c : dataSet.values()) {
            count += c;
        }

        Set<Integer> resultSet = new HashSet<Integer>();
        comb(-1, dataSet, count, 0, resultSet);
        System.out.println(resultSet);
        System.out.println(resultSet.size());
    }
}
