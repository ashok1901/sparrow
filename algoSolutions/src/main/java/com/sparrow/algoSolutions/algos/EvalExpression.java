package com.sparrow.algoSolutions.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvalExpression 
{
    private double operate(double op1, double op2, String operator) {
        switch(operator) {
            case "+" : return op1 + op2;
            case "-" : return op1 - op2;
            case "*" : return op1 * op2;
            case "/" : if (op2 == 0) {
                            throw new IllegalArgumentException("Div by zero");
                        }
                        return op1/op2;
            default : throw new IllegalArgumentException("Unknown operator"); 
        }
    }

    private boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*");
    }

    public double evaluate(List<Object> exp) {
        if (exp == null) {
            return 0;
        }

        Stack<String> operator = new Stack<String>();
        Stack<Double> operands = new Stack<Double>();
        for (Object entry : exp) {
            if (operands.size() == 2) {
                operands.push(operate(operands.pop(), operands.pop(), operator.pop()));
            }

            if (entry instanceof List) {
                operands.push(evaluate((List<Object>)entry));
            } else if (isOperator(entry.toString())) {
                operator.push(entry.toString());
            } else {
                operands.push(Double.valueOf(entry.toString()));
            }
        }

        if (operands.size() == 2) {
            operands.push(operate(operands.pop(), operands.pop(), operator.pop()));
        }

        return operands.pop();
    }

    public static void main(String[] args) {
        List<Object> exp = new ArrayList<Object>();
        exp.add("-");
        exp.add("+");
        exp.add(12);
        exp.add(12);
        List<Object> subExp = new ArrayList<Object>();
        subExp.add("*");
        subExp.add(123);
        subExp.add(3);
        exp.add(subExp);

        EvalExpression eval = new EvalExpression();
        System.out.println(eval.evaluate(exp));
    }
}
