package com.sparrow.algoSolutions.algos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AlgorithmRunner 
{
    private static void runInsertSpace()
    {
        Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");dict.add("sand");
        dict.add("dog");
        System.out.println(Algorithm.insertSpacesDP("catsanddog", dict));
        
        Set<String> dict2 = new HashSet<String>();
        dict2.add("i");dict2.add("am");
        dict2.add("student");dict2.add("from");dict2.add("water");dict2.add("loo");
        dict2.add("fromwater");
        System.out.println(Algorithm.insertSpacesDP("iamstudentfromwaterloo", dict2));

    }
    
    private static void printAllParanthesis() {
        Set<String> results1 = Algorithm.allParanthesis(3);
        Set<String> results2 = Algorithm.paranthesis(3);
        System.out.println(results1.size() + " " + results2.size());
        System.out.println("Comparison ...");
        for (String val : results1) {
            if(!results2.contains(val)) {
                System.out.println(val);
            }
        }
    }

    private static void runBinarySearchUnknownLength() {
        int[] arr = new int[]{1, 3, 5, 6, 78, 64, 34, 99};
        Arrays.sort(arr);
        System.out.println(Algorithm.binarySearchUnknownLength(arr, 63));
    }

    private static void runCandiesDistribution()
    {
        int[] r = new int[]{1,2,2};
        System.out.println(Algorithm.candies(r));
    }

    private static void runTop3() {
        int[] data = new int[]{1, 3, 5, 6, 78, 64, 34, 99};
        int[] res = Algorithm.top3(data);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    private static void runRotatedLookup() {
        int[] data = new int[] {13, 17, 21, 31, 1, 7, 9};
        int index = Algorithm.rotatedSortedLookup(data, 13);
        System.out.println((index != -1 ? data[index] : null) + " at index " + index);

        // Not rotated
        data = new int[] {13, 17, 21, 31, 34, 56, 78, 90};
        index = Algorithm.rotatedSortedLookup(data, 13);
        System.out.println((index != -1 ? data[index] : null) + " at index " + index);

    }
    public static void main(String[] args) 
    {
//        int[] arr = new int[] {-1, 3, 4, -12, -2, -11, -5, -3};
//        System.out.println(Algorithm.maxSumArray(arr));
//        System.out.println(Algorithm.maxSumNonEmptyArray(arr));

        /**
         *                           A
         *                       B        G
         *                   C       F
         *               D        E
         */
//        BinaryTree<Character> bt = new BinaryTree<Character>('A');
//        BTreeNode<Character> A = bt.getRoot();
//        BTreeNode<Character> B = bt.insertChildNode(A, 'B', true);
//        BTreeNode<Character> G = bt.insertChildNode(A, 'G', false);
//        BTreeNode<Character> C = bt.insertChildNode(B, 'C', true);
//        BTreeNode<Character> F = bt.insertChildNode(B, 'F', false);
//        BTreeNode<Character> D = bt.insertChildNode(C, 'D', true);
//        BTreeNode<Character> E = bt.insertChildNode(C, 'E', false);
//
//        System.out.print("INPUT: ");
//        bt.inorderRecursive(A);
//        BTreeNode<Character> flip = Algorithm.flipTree(A, null, null);
//        System.out.print("OUTPUT: ");
//        bt.inorderRecursive(flip);
//
//        System.out.println("Special printing output");
//        Algorithm.doSpecialprint("benchmark");

//        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 12, 31, 44, 34, 56, 77, 22, 36, 76, 12, 35};
//        
//        System.out.println(Algorithm.printSubset(a, -1, new ArrayList<Integer>()));
        // runInsertSpace();
        // printAllParanthesis();
        //runBinarySearchUnknownLength();
        //runCandiesDistribution();
        //runTop3();
        runRotatedLookup();
    }
}
