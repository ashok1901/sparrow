package com.sparrow.algoSolutions.algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidateStrAsNum 
{
    private static Map<Character, Integer> charDigitMap = 
            new HashMap<Character, Integer>();

        static {
            charDigitMap.put('0', 0);
            charDigitMap.put('1', 1);
            charDigitMap.put('2', 2);
            charDigitMap.put('3', 3);
            charDigitMap.put('4', 4);
            charDigitMap.put('5', 5);
            charDigitMap.put('6', 6);
            charDigitMap.put('7', 7);
            charDigitMap.put('8', 8);
            charDigitMap.put('9', 9);
        }

    private static boolean isValidNumber(String str) {
        Set<Character> validChars = new HashSet<Character>();
        validChars.addAll(charDigitMap.keySet());
        validChars.add('.');


        boolean anyDigitEncounterd = false;
        for(int index = 0;index < str.length();index++) {
            char c = str.charAt(index);
            if (c == '-' || c == '+') {
                if (index == 0) {
                    // First char as sign is acceptable
                    continue;
                }

                // Otherwise not
                return false;
            }

            if (c == '.') {
                if(validChars.contains(c)) {
                    // No more decimals are accepted.
                    validChars.remove(c);
                    continue;
                }

                // Otherwise not
                return false;
            }

            if (validChars.contains(c)) {
                // String is valid only if has at least a digit.
                anyDigitEncounterd = true;
            } else {
                return false;
            }
        }

        return anyDigitEncounterd;
    }

    public static void main(String[] args) {
        String givenStr = "12.33.4";
        System.out.println(isValidNumber(givenStr));
    }
}
