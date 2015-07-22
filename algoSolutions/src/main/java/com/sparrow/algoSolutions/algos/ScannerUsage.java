package com.sparrow.algoSolutions.algos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerUsage 
{
    public static void main(String[] args) {
        // Read all lines, line by line
        try {
            // This is how this is used in hacker rank
            //Scanner sc = new Scanner(new File(System.in));
            String inputFile = "C:\\test\\scannerReader1.txt";
            Scanner sc = new Scanner(new File(inputFile));
            List<String> data = new ArrayList<String>();
            while(sc.hasNextLine()) {
                data.add(sc.nextLine());
            }

            if (data.isEmpty()) {
                System.out.println("=== No Input ===");
            } else {
                for (String x : data) {
                    System.out.println(x);
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//
//        try {
//            // This is how this is used in hacker rank
//            //Scanner sc = new Scanner(new File(System.in));
//            String inputFile = "C:\\test\\scannerReader.txt";
//            Scanner sc = new Scanner(new File(inputFile));
//            String nStr = sc.nextLine();
//            int n = Integer.parseInt(nStr);
//            String dataStr = sc.nextLine();
//            String[] dataTokens = dataStr.split("\\s+");
//            int[] data = new int[dataTokens.length];
//            for (int i = 0; i < dataTokens.length; i++) {
//                data[i] = Integer.parseInt(dataTokens[i]);
//            }
//
//            System.out.println(n);
//            for (int x : data) {
//                System.out.print(x);
//                System.out.print(" ");
//            }
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) {
//        String inputFile = "C:\\test\\scannerReader.txt";
//        Scanner sc;
//        try {
//            sc = new Scanner(new File(inputFile));
//            int count = 0;
//            while (sc.hasNextLine() && count < 10) {
//                String line1 = sc.next();
//                System.out.print(line1);
//                count++;
//            }
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}
