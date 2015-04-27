package com.sparrow.algoSolutions.algos;

public class StrCharPermutations {

    private static void permute(String[] arr, int depth, String currentPerm) {
        if (depth == arr.length) {
            System.out.println(currentPerm);
            return;
        }

        for (int i = 0; i < arr[depth].length();i++) {
            permute(arr, depth + 1, currentPerm + arr[depth].charAt(i));
        }
    }

    public static void main(String[] args) {
        String[] strArr = new String[] {"red", "fox", "jumping"};
        permute(strArr, 0, "");
    }
}
