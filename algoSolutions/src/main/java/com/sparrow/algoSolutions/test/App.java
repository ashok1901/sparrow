package com.sparrow.algoSolutions.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.sparrow.algoSolutions.basicDS.CustomStack;

/**
 * Hello world!
 *
 */
public class App 
{
    private static int maxProfit(int length, int[] cuts, 
                                 int[] profits, int[] L) 
    {
        if (L[length] >= 0) {
            System.out.println("Reusing for " + length);
            return L[length];
        }

        int max = 0;
        if (length != 0) {
            for (int i = 0; i < cuts.length; i++) {
                if (cuts[i] <= length) {
                    int tmp = maxProfit(length - cuts[i], cuts, profits, L) + profits[i];
                    max = max > tmp ? max : tmp;
                }
            }
        }

        return max;
    }

    private static int rodCutProblem(int length, int[] cuts, int[] profits)
    {
        int[] L = new int[length + 1];
        for (int i = 0; i < L.length; i++) {
            // Initialize intermediate results holder array
            L[i] = -1;
        }

        int i = 0;
        while(i <= length) {
            L[i] = maxProfit(i, cuts, profits, L);
            i++;
        }

        return L[length];
    }


    private static void calTest()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1969);
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DATE, 31);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        System.out.println(cal.getTimeInMillis());
        // Just to try shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("Shutdown hook kicked in.");
            }
        });

        int i = 0;
        while(i < 100) {
            try {
                System.out.println("Sleeping at " + i);
                Thread.currentThread().sleep(1000);
                if (i == 10) {
                    throw new RuntimeException("Done sleeping for " + i);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            i++;
        }

        cal.setTimeInMillis(0);
        System.out.println(cal.getTime());
    }

    private static int maxSumSubSequence(int[] array, int endIndex)
    {
        if (endIndex < 0) {
            throw new IllegalArgumentException("Given end index is negative...");
        }

        if (endIndex == 0) {
            return Math.max(array[endIndex], 0);
        }

        int subProbSol = maxSumSubSequence(array, endIndex - 1);
        return Math.max(subProbSol + array[endIndex], subProbSol);
    }

    private static int maxSumContiuousSubArray(int[] array)
    {
        int bestTillThis = 0, bestSoFar = 0;
        for (int i = 0; i< array.length; i++) {
            bestTillThis = Math.max(0, bestTillThis + array[i]);
            bestSoFar = Math.max(bestTillThis, bestSoFar);
        }

        return bestSoFar;
    }

    private static List<Integer> longestIncreasingSubArray(int[] array)
    {
        List<Integer> longestSoFar = new ArrayList<Integer>();
        List<Integer> currentLongest = new ArrayList<Integer>();
        if (array.length == 0) {
            return longestSoFar;
        }

        longestSoFar.add(array[0]);
        currentLongest.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i-1]) {
                currentLongest.add(array[i]);
                continue;
            }

            // Equality >= decides if last occurence of same lenght sub-seq
            // to be retured. if > then first occurence would be returned.
            if (currentLongest.size() >= longestSoFar.size()) {
                // SWAP
                List<Integer> tmp = longestSoFar;
                longestSoFar = currentLongest;
                currentLongest = tmp;
            }

            currentLongest.clear();
        }

        // Equality >= decides if last occurence of same lenght sub-seq
        // to be retured. if > then first occurence would be returned.
        return currentLongest.size() >= longestSoFar.size() 
                    ? currentLongest : longestSoFar;
    }

    private static Integer[] longestIncrSubArray(Integer[] array)
    {
        int bestStart = 0;
        int bestEnd = 0;

        if (array.length <= 1) {
            return array;
        }

        int start = bestStart;
        int end = bestEnd;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i-1]) {
                end = i;
                continue;
            }

            // Equality >= decides if last occurence of same lenght sub-seq
            // to be retured. if > then first occurence would be returned.
            if ((bestEnd - bestStart) < (end - start)) {
                // This is longer than best so far
                bestStart = start;
                bestEnd = end;
            }
            start = i;
            end = i;
        }

        // Equality >= decides if last occurence of same lenght sub-seq
        // to be retured. if > then first occurence would be returned.
        if ((bestEnd - bestStart) < (end - start)) {
            // This is longer than best so far
            bestStart = start;
            bestEnd = end;
        }

        int bestLength = bestEnd - bestStart + 1;
        Integer[] result = new Integer[bestLength];
        for (int i = 0; i < bestLength; i++) {
            result[i] = array[bestStart + i];
        }

        return result;
    }

    public static int longestIncreasingSubSeq(int[] arr, int start, int end)
    {
        //YTBI: Yet To Be Impl
        /**
         * n*2 solution, start with element at index i and reap the longest 
         * sequence starting with i. Do so for all elements, keep track of 
         * longest so far.
         */
        return -1;
    }

    /**
     * By extra space this is some optimization otherwise solution is n*2
     */
    private static Map<String, Integer> subSol = 
        new HashMap<String, Integer>();
    private static int count;
    private static int longestPalindrom(String s, int start, int end, 
                                        boolean useExtraSpace)
    {
        //System.out.println("RECUR");
        count++;
        if (end == start) {
            return 1;
        }

        if (s.isEmpty() || end < start) {
            return 0;
        }

        if (s.charAt(start) == s.charAt(end)) {
            return 2 + derivePalindrom(s, start + 1, end - 1, useExtraSpace);
        }

        return Math.max(derivePalindrom(s, start + 1, end, useExtraSpace), 
                        derivePalindrom(s, start, end - 1, useExtraSpace));
    }

    private static int derivePalindrom(String s, int startIndex, int endIndex, boolean useExtraSpace)
    {
        if (!useExtraSpace) {
            return longestPalindrom(s, startIndex, endIndex, useExtraSpace);
        }

        String key = startIndex + "_" + endIndex;
        //System.out.println(key);
        if (!subSol.containsKey(key)) {
            subSol.put(key, longestPalindrom(s, startIndex, endIndex, useExtraSpace));
        } else {
            //System.out.println("USING EARLIER SOLUTION " + startIndex + " " + endIndex);
        }

        return subSol.get(key); 
    }

    private static <T> void printArray(T[] arr)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
        } else {
            sb.append("NULL");
        }

        sb.append("]");
        System.out.println(sb.toString());
    }

    private static Integer cc(int[] denom, int v)
    {
        Integer[][] table = new Integer[v + 1][denom.length + 1];

        for (int val = 0; val <= v; val++) {
            for (int c = 1; c < denom.length; c++) {
                // Nothing to sum up
                if (val == 0) {
                    table[val][c] = 0;
                }

                // No coin given or left
                if (c < 0) {
                    table[val][c] = null;
                }

                if (denom[c] > val) {
                    table[val][c] = table[val][c-1];
                } else {
                    table[val][c] = pickMin(table[val - denom[c]][c], table[val][c-1]);
                }
            }
        }

        Integer actualSol = null;
        for (int i = 0; i < denom.length; i++) {
            actualSol = pickMin(actualSol, table[v][i]);
        }

        return actualSol;
    }

    private static Integer pickMin(Integer min, int a) {
        return min == null ? a : Math.min(min, a);
    }

//    private static void perm(Character[] in, int index)
//    {
//        if (index  == 0) {
//            printArray(in);
//        }
//
//        for (int i = 0; i < len; i++) {
//            
//        }
//    }
//
//    private static void swap(char[] in, int i, int j) {
//        char tmp = in[i];
//        in[i] = in[j];
//        in[j] = tmp;
//    }

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        //calTest();

        int[] arr = new int[] {-1, 0, 5, 11};
        //System.out.println(maxSumSubSequence(arr, arr.length - 1));
        //System.out.println(maxSumContiuousSubArray(arr));
        
        //printArray(longestIncrSubArray(new Integer[] {1, 3, 2, 5, 11}));
        //String s = "absfsdffr4324dgregsggsgdsresfsfarsfdsfgsdf";
        // NOT WORKING FOR BELOW CASE
//        String s = "abddfba";
//        System.out.println(longestPalindrom(s, 0, s.length() - 1, true));
//        System.out.println(s.length() + " " + count);
//        System.out.println(cc(new int[]{1,2,5,7}, 11));

//        Map<Integer, Integer> dataSet = new HashMap<Integer, Integer>();
//        dataSet.put(1, 1);
//        dataSet.put(2, 1);
//        dataSet.put(3, 1);
//        dataSet.put(4, 2);
//        int count = 0;
//        for (int c : dataSet.values()) {
//            count+=c;
//        }
//
//        Set<Integer> resultSet = new HashSet<Integer>();
//        comb(-1, dataSet, count, 0, resultSet);
//        System.out.println(resultSet);
//        System.out.println(resultSet.size());

        // ROD CUT PROBLEM
//        int[] cuts = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
//        int[] profits = new int[]{1, 5, 8, 9, 10, 17, 17,20};
//        System.out.println(rodCutProblem(8, cuts, profits));
        
//        System.out.println(squareRoot("29584"));
//        System.out.println(squareRootByBinarySearch(10000));
//        System.out.println(isValidNumber("-."));

//        String[] strArr = new String[] {"red", "fox", "super"};
//        permute(strArr, 0, "");
//        reverseStack();
    }
}
