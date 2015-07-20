package com.sparrow.algoSolutions.algos;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HuffmanEncode {
	private static class  HTreeNode
	{
		private HTreeNode onZero;
		private HTreeNode onOne;
		private boolean isLeaf;
		private char val;
		
		public HTreeNode read(char c) {
			return c == '0' ? onZero : onOne;
		}
		
		public HTreeNode transit(char c) {
			if (c == '0') {
				if (onZero == null) {
					onZero = new HTreeNode();
				}
				
				return onZero;
			}
			
			if (onOne == null) {
				onOne = new HTreeNode();
			}
			
			return onOne;
		}
	}
	
	public HTreeNode buildHTree(Map<Character, String> dict)
	{
		HTreeNode hTreeRoot = new HTreeNode();
		
		for(Entry<Character, String> entry : dict.entrySet()) {
			HTreeNode current = hTreeRoot;
			char c = entry.getKey();
			String code = entry.getValue();
			for (int i = 0; i< code.length(); i++) {
				char codedChar = code.charAt(i);
				HTreeNode next = current.transit(codedChar);
				current = next;
				if (i == code.length() - 1) {
					// if it's last then update val and isLeaf
					next.isLeaf = true;
					next.val = c;
				}
			}
		}
		
		return hTreeRoot;
	}
	
	public String decode(String text, HTreeNode root) {
		StringBuilder sb = new StringBuilder();
		HTreeNode cur = root;
		for (int i = 0; i<text.length(); i++) {
			char c = text.charAt(i);
			cur = cur.read(c);
			if (cur == null) {
				throw new IllegalArgumentException("No transition for  " + c); 
			}
			if (cur.isLeaf) {
				sb.append(cur.val);
				cur = root;
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Map<Character, String> dict = new HashMap<Character, String>();
		dict.put('a', "01");
		dict.put('b', "11");
		
		HuffmanEncode hCode = new HuffmanEncode();
		HTreeNode hTreeRoot = hCode.buildHTree(dict);
		
		System.out.println(hCode.decode("0111010101", hTreeRoot));
	}
}
