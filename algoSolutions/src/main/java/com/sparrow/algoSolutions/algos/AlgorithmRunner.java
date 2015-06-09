package com.sparrow.algoSolutions.algos;

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
        Algorithm.printAllParenthesis(new StringBuilder(), 2, 2);
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
        runInsertSpace();
        //printAllParanthesis();
    }
}
