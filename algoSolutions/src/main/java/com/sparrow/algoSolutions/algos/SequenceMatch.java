package com.sparrow.algoSolutions.algos;

public class SequenceMatch 
{
	private final String str, text;
	public SequenceMatch(String str, String text) {
		this.str = str;
		this.text = text;
	}
	
	private int seqMatchRec(int iStr, int iText) {
		if (iStr >= str.length()) {
			return 1;
		}
		if (iText >= text.length()) {
			return 0;
		}
		
		int count = 0;
		char charToLookup = str.charAt(iStr);
		for (int i = iText; i < text.length(); i++) {
			if (text.charAt(i) == charToLookup) {
				count += seqMatchRec(iStr + 1, i + 1);
			}
		}
		
		return count;
	}
	
	public int sequenceMatch() {
		return seqMatchRec(0, 0);
	}
	
	public static void main(String[] args) {
		String str = "cat";
		String text = "catapult";
				
		SequenceMatch sqMatch = new SequenceMatch(str, text);
		System.out.println(sqMatch.sequenceMatch());
	}
}
