package com.sparrow.algoSolutions.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sparrow.algoSolutions.basicDS.BinaryTree.BTreeNode;

public class Algorithm 
{
    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * Maximum sum sub-array, Kadene's implementation.
     */
    public static int maxSumArray(int[] array) {
        int overAllMax = 0;
        int intermediateMax = 0;

        for (int val : array) {
            intermediateMax += val;
            intermediateMax = max(intermediateMax, 0);
            overAllMax = max(overAllMax, intermediateMax);
        }

        overAllMax = max(overAllMax, intermediateMax);
        return overAllMax;
    }

    /**
     * Its tested for couple of cases...
     * 
     * @param current
     * @param right
     * @param left
     * @return
     */
    public static <T> BTreeNode<T> flipTree(
        BTreeNode<T> current, 
        BTreeNode<T> right, 
        BTreeNode<T> left) 
    {
        if (current == null) {
            return right;
        }

        BTreeNode<T> newRoot = 
            flipTree(current.left, current, current.right);

        current.left = left;
        current.right = right;

        return newRoot;
    }

    /**
     * Maximum sum sub-array, Kadene's implementation.
     * !!!!!
     */
    public static int maxSumNonEmptyArray(int[] array) {
        System.out.println("NOT WORKIGN");
        int overAllMax = array[0];
        int intermediateMax = array[0];

        for (int i = 1; i < array.length; i++) {

            if (array[i] > 0) {
                // Collect it as it contibutes +ve
                intermediateMax += array[i];
            } else if (array[i] > intermediateMax) {
                // discard the older one and pick this single node.
                intermediateMax = array[i];
            }

            if (overAllMax < intermediateMax) {
                overAllMax = intermediateMax;
            }
        }
//        for (int val : array) {
//            intermediateMax += val;
//            intermediateMax = max(intermediateMax, 0);
//            overAllMax = max(overAllMax, intermediateMax);
//        }

        overAllMax = max(overAllMax, intermediateMax);
        return overAllMax;
    }

    private static void printSpecial(String str, int s, int e) {
        for (int i = 0; i < str.length();) {
            if (i < s || i > e) {
                System.out.print(str.charAt(i));
                i++;
            } else {
                System.out.print(e - s + 1);
                i =  e + 1;
            }
        }
        System.out.print("\n");
    }

    /**
     * Working
     * @param str
     */
    public static void doSpecialprint(String str) {
        if (str == null) {
            return;
        }

        int s = 1,e = str.length() - 2;
        while(s <= e) {
            printSpecial(str, s, e);
            if (s != e) {
                printSpecial(str, s, e - 1);
                printSpecial(str, s + 1, e);
            }

            s++;e--;
        }
    }

    public static int printSubset(int[] a, int i, List<Integer> set) {
        if (a == null) {
            return 0;
        }

        
        System.out.println(set);
        int count = 1;
        for (int j = i + 1; j < a.length; j++) {
            set.add(a[j]);
            count += printSubset(a, j, set);
            set.remove(set.size() - 1);
        }

        return count;
    }

    /**
     * Tested for simple examples
     * @param str
     * @param dict
     * @return
     */
    public static List<String> insertSpacesDP(String str, Set<String> dict)
    {
        int n = str.length();
        List<List<String>> L = new ArrayList<List<String>>();
        for (int i = 0; i < n; i++) {
            L.add(i, new ArrayList<String>());
        }

        for (int current = 0; current < n; current++) {
            List<String> currentList = new ArrayList<String>();
            String tillCurrentStr = str.substring(0, current + 1);
            if (dict.contains(tillCurrentStr)) {
                currentList.add(tillCurrentStr);
            }

            for (int prev = current - 1 ; prev > 0; prev--) {
                String subStr = str.substring(prev, current + 1);
                List<String> tillPrev = L.get(prev - 1);
                if (!tillPrev.isEmpty() && dict.contains(subStr)) {
                    for (String s : tillPrev) {
                        currentList.add(s + " " + subStr);
                    }
                }
            }
            L.add(current, currentList);
        }

        return L.get(n - 1);
    }

    /**
     * Tested for simple examples
     * @param str
     * @param dict
     * @return
     */
    public static List<String> insertSpaces(String str, Set<String> dict)
    {
        List<String> strs = new ArrayList<String>();
        if (str.isEmpty()) {
            return strs;
        }

        if (dict.contains(str)) {
            strs.add(str);
        }

        for (int j = 0; j < str.length(); j++) {
            String left = str.substring(0, j);

            if (dict.contains(left)) {
                List<String> rightStrs = 
                    insertSpaces(str.substring(j), dict);
                for (String s : rightStrs) {
                    strs.add(left + " " + s);
                }
            }

        }

        return strs;
    }

    private static boolean isOverflow(int[] arr, int mid) {
        try {
            int x = arr[mid];
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }

        return false;
    }

    /**
     * Tested for couple of simple cases.
     * @param arr
     * @param x
     * @return
     */
    public static int binarySearchUnknownLength(int[] arr, int x) 
    {
        int start = 0;
        int end = 0;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if (isOverflow(arr, mid)) {
                end = mid;
            } else if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                start = end;
                end = (end == 0) ? 1 : 2*end;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

//    public static int countPrintChars(int n) {
//        if (n <= 4) {
//            return n;
//        }
//        int max = n;
//        for (int i = n - 3; i >= 1; i--) {
//            max = Math.max(max, 2*countPrintChars(i) + countPrintChars(n));
//        }
//    }

    /**
     * working
     */
    private static char OPEN_PARANTHESIS = '(';
    private static char CLOSE_PARANTHESIS = ')';
    private static void printAllParenthesis(char[] data, int pos, 
                                           int open, int close, int n, Set<String> results) 
    {
        if (close == n) {
            results.add(new String(data));
            System.out.println(data);
            return;
        } else {
            if (open > close) {
                data[pos] = CLOSE_PARANTHESIS;
                printAllParenthesis(data, pos + 1, open, close + 1, n, results);
            } 

            if (open < n) {
                data[pos] = OPEN_PARANTHESIS;
                printAllParenthesis(data, pos + 1, open + 1, close, n, results);
            }
        }
    }

    /**
     * NOT WORKING !!!!!!!!!!!!
     * 
     * @param n
     * @return
     */
    public static Set<String> allParanthesis(int n) {
        Set<String> results = new HashSet<String>();
        printAllParenthesis(new char[2*n], 0, 0, 0, n, results);

        return results;
    }

    public static Set<String> paranthesis(int n) {
        char[] data = new char[2*n];
        Set<String> res = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            int front = i;
            int tail = 2*n - i -1;
            data[front] = OPEN_PARANTHESIS;
            data[tail] = CLOSE_PARANTHESIS;
        }
        String out = new String(data);
        System.out.println(out);

        res.add(out);

        int toMove = n;
        for(int i = 1; i <= n; i++) {

            int nextToMove = toMove + 1;
            for (int j = 1; j <= n - i; j++) {
                // n - 1 left shifts
                char tmp = data[toMove];
                data[toMove] = data[toMove - 1];
                data[toMove - 1] = tmp;
                toMove = toMove - 1;

                out = new String(data);
                System.out.println(out);
                res.add(out);
            }
            toMove = nextToMove;
        }

        return res;
    }

    /**
     * Not working not tested
     * @param r
     * @return
     */
    public static int candies(int[] r) {
        int prev = 1;
        int total = 1;
        for (int i = 1; i < r.length; i++) {
            if (r[i] > r[i - 1]) {
                prev++;
                
            } else {
                prev = 1;
            }
            total += prev;
        }

        return total;
    }

    private static void updateTop3(int[] res, int x) {
        if (x <= res[2]) {
            return;
        } else if (x >= res[0]) {
            res[2] = res[1];
            res[1] = res[0];
            res[0] = x;

        } else if (x >= res[1]) {
            res[2] = res[1];
            res[1] = x;

        } else {
            // Now no need to check equality
            res[2] = x;
        }
    }

    public static int[] top3(int[] data) {
        int[] res = new int[] {Integer.MIN_VALUE, 
                               Integer.MIN_VALUE, 
                               Integer.MIN_VALUE};

        if (data == null || data.length < 3) {
            return data;
        }

        for (int i = 0; i < data.length; i++) {
            updateTop3(res, data[i]);
        }

        return res;
    }
    
    private static int findPartition(int[] data, int s, int e) {
        if (s == e) {
            return -1;
        }
        if (e - s == 1) {
            // Only two number left
            if (data[s] > data[e]) {
                return s;
            } else {
                return -1;
            }
        }

        int mid = s + (e - s)/2;
        if (data[s] < data[mid]) {
            return findPartition(data, mid, e);
        } else {
            return findPartition(data, s, mid);
        }
    }

    private static int binarySearch(int[] data, int x, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s)/2;
            if (data[mid] == x) {
                return mid;
            } else if (data[mid] > x) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return -1;
    }

    public static int rotatedSortedLookup(int[] data, int x) {
        int end = data.length - 1;
        int pivot = findPartition(data, 0, end);

        if (pivot == -1) {
            // Not rotated
            return binarySearch(data, x, 0, end);
        }

        if (data[0] <= x && data[pivot] >= x) {
            return binarySearch(data, x, 0, pivot);
        } else if (data[end] >= x) {
            return binarySearch(data, x, pivot + 1, end);
        } else {
            return -1;
        }
    }
}
