package com.sparrow.algoSolutions.algos;

/**
 * Algorithm to compute square root of a given number. 
 * <br><B>Note:</B> If given number is not a perfect square then it compute
 * floorInt(sqaureRoot(n)). IOW, only integer part of sqaure root is needed.
 * <br>For example: squareRoot(25) = 4, squareRoot(24) = squareRoot(23) = 4
 * 
 * @author Ashok
 */
public class SquareRoot 
{

    private static int squareRootByBinarySearch(int num) {

        int start = 1;
        // Probably we can probe between 1 to num/2 because
        // I think there is some property that 1 <= squareRoot(num) <= num/2
        int end = num;
        int mid = 0;

        while(start <= end) {
            mid = start + (end - start)/2;
            // Doing comparison with num/mid instead of
            // doing mid*mid == num to avoid if mid*mid
            // goes overflow
            int d = num/mid;
            if (d == mid) {
                break;
            } else if (mid < d) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return mid;
    }

    private static int squareRoot(String abc) {
        if (abc.length() == 0) {
            System.out.println("Illegal Arg " + abc);
            return -1;
        }

        int index = 0;
        int divisor = 0;
        int toDivide = 0;
        int sol = 0;
        int residual = 0;

        String share = "";
        while(index < abc.length()) {
            share = takeShareFromString(abc, index);
            index = index + share.length();

            toDivide = residual*100 + Integer.valueOf(share);
            divisor = 2*sol;

            int d = 0;
            if (toDivide >= divisor) {
                d = getAppropriateAttachDigit(toDivide, divisor);
                int intermediateDiv = divisor*10 + d;
                residual = toDivide - intermediateDiv*d;
            }


            sol = sol*10 + d;
        }

        return sol;
    }

    
    private static String takeShareFromString(String abc, int index) {
        String share = null;
        if (index > abc.length()) {
            return "";
        }

        boolean isOdd = abc.length()%2 != 0 ? true : false;
        if (index == 0 && isOdd) {
            share = abc.substring(index, index + 1);
        } else {
            share = abc.substring(index, index + 2);
        }

        return share;
    }

    private static int getAppropriateAttachDigit(int toDivide, int divisor) 
    {
        int d = 1;
        int div = divisor*10 + d;
        while(div*d <= toDivide && d < 10) {
            d++;
            div = divisor*10 + d;
        }

        return --d;
    }

    public static void main(String[] args) 
    {
        // Implementation of standard school time procedure
        int num = 841;
        System.out.println(num + " has square root " + squareRoot(String.valueOf(num)));

        // Square root by binary search. 
        num = 290521;
        System.out.println(num + " has square root " + squareRootByBinarySearch(num));
    }
}
