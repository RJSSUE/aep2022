package edu.berkeley.aep;

import java.util.Stack;
import java.util.StringTokenizer;

//Understands the arithmetic expression and compute its value
public class Calculator {
    private final String expression;
    private Stack<Double> values = new Stack<>();
    private Stack<String> operators = new Stack<>();
    public Calculator(String content){
        expression = content;
        tokenize();
    }

    public void tokenize(){
        var tokenizer = new StringTokenizer(expression,"+-*/",true);
        while(tokenizer.hasMoreTokens()){
            String nextToken = tokenizer.nextToken();
            if ("+-".contains(nextToken)) { // "*/" > "+-"
                while (!operators.isEmpty() && "*/".contains(operators.peek())) {
                    values.add(oneStep());
                }
            }
            if ("+-*/".contains(nextToken)){
                operators.add(nextToken);
            } else {
                values.add(Double.parseDouble(nextToken));
            }
        }
    }

    public Double oneStep() {
        if (values.size()<2){
            throw new RuntimeException("Invalid expression!");
        }
        var value2 = values.pop();
        var value1 = values.pop();
        switch (operators.pop()){
            case "+":
                return value1+value2;
            case "-":
                return value1-value2;
            case "*":
                return value1*value2;
            case "/":
                return value1/value2;
            default:
                throw new RuntimeException("Invalid expression!");
        }
    }

    public Double calculate() {
        while (!operators.isEmpty()){
            values.add(oneStep());
        }
        if (values.size()!=1){
            throw new RuntimeException("Invalid expression!");
        }
        return values.get(0);
    }
}
