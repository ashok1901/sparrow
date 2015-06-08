package com.sparrow.algoSolutions.basicDS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree<T> implements Iterable<T>{

    public static class BTreeNode<T> 
    {
        public BTreeNode<T> left;
        public BTreeNode<T> right;
        public T value;

        public BTreeNode(T val) {
            left = null;
            right = null;
            value = val;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private BTreeNode<T> root;

    public BinaryTree(T rootVal) 
    {
        root = new BTreeNode<T>(rootVal);
    }

    public BTreeNode<T> insertChildNode(BTreeNode<T> parent, T val, boolean isLeft)
    {
        if (parent == null) {
            throw new RuntimeException("Parent is null !!");
        }

        BTreeNode<T> n = new BTreeNode<T>(val);
        if(isLeft){
            parent.left = n;
        } else {
            parent.right = n;
        }

        return n;
    }

    public BTreeNode<T> getRoot()
    {
        return root;
    }

    public void inorder() {
        if (root == null) {
            return;
        }

        // NOT WORKING...
        BTreeNode<T> tmp = root;
        CustomStack<BTreeNode<T>> stack = 
            new CustomStack<BinaryTree.BTreeNode<T>>(100);

        stack.push(tmp);
        while(!stack.isEmpty()) {
//            System.out.println(tmp);
//            System.out.println(stack);
            while(tmp.left != null) {
                tmp = tmp.left;
                stack.push(tmp);
            }
//            System.out.println(tmp.value);
            if (tmp.right != null) {
                System.out.print(tmp.value + " ");
                tmp = tmp.right;
                stack.push(tmp);
            } else {
                while(tmp.right == null && !stack.isEmpty()) {
                    tmp = stack.pop();
                    System.out.print(tmp.value + " ");
                }
            }
        }
    }

    public String BFSTraversal() {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            List<BTreeNode<T>> levelNodes = new LinkedList<BTreeNode<T>>();
            levelNodes.add(root);
            while(!levelNodes.isEmpty()) {
                BTreeNode<T> front = levelNodes.remove(0);
                sb.append(front.value).append(" ");
                if (front.left != null) {
                    levelNodes.add(front.left);
                }

                if (front.right != null) {
                    levelNodes.add(front.right);
                }
            }
        }

        return sb.toString();
    }

    public void inorderRecursive(BTreeNode<T> root) {
        if (root == null) {
            return;
        }

        inorderRecursive(root.left);
        System.out.print(root.value + " ");
        inorderRecursive(root.right);
    }

    public String levelWisePrint() {

        StringBuilder sb = new StringBuilder();
        if (root != null) {
            List<BTreeNode<T>> data = new LinkedList<BTreeNode<T>>();
            List<BTreeNode<T>> transit = new LinkedList<BTreeNode<T>>();

            data.add(root);
            while(!data.isEmpty()) {
                while (!data.isEmpty()) {
                    BTreeNode<T> front = data.remove(0);
                    sb.append(front.value);
                    if (front.left != null) {
                        transit.add(front.left);
                    }

                    if (front.right != null) {
                        transit.add(front.right);
                    }
                    sb.append(" ");
                }

                sb.append("\n");
                //Swap data and transit
                List<BTreeNode<T>> tmp = data;
                data = transit;
                transit = tmp;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        /**
         *              root
         *         l                 r
         *               lr     rl        rr
         */
        BinaryTree<String> bt = new BinaryTree<String>("root");
        BTreeNode<String> rl = bt.insertChildNode(bt.getRoot(), "l", true);
        BTreeNode<String> rlr = bt.insertChildNode(rl, "lr", false);
        BTreeNode<String> rr = bt.insertChildNode(bt.getRoot(), "r", false);
        BTreeNode<String> rrr = bt.insertChildNode(rr, "rr", false);
        BTreeNode<String> rrl = bt.insertChildNode(rr, "rl", true);
        
        System.out.println(bt.levelWisePrint());
        bt.inorderRecursive(bt.root);
    }

    public Iterator<T> iterator() 
    {
        new Iterator<T>() {

            public boolean hasNext() {
                // TODO Auto-generated method stub
                return false;
            }

            public T next() {
                // TODO Auto-generated method stub
                return null;
            }

            public void remove() {
                // TODO Auto-generated method stub
                
            }
        };
    }
}
