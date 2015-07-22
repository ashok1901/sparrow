package com.sparrow.algoSolutions.algos;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int row = 0; row < numRows; row++) {
            List<Integer> thisRow = new ArrayList<Integer>();
            for (int c = 0; c <= row; c++) {
                if (c == row || c == 0) {
                    thisRow.add(1);
                } else {
                    thisRow.add(res.get(row - 1).get(c - 1) + res.get(row - 1).get(c));
                }
            }
            
            res.add(thisRow);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		new PascalTriangle().generate(3);
	}
}
