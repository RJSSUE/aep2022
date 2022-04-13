package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//Understands the arithmetic expression and compute its value
public class Calculator {
    private final StringTokenizer expression;
    private Stack<Double> values = new Stack<>();
    private Stack<String> operators = new Stack<>();
    public Calculator(String content){
        expression = new StringTokenizer(content,"+-*/",true);
    }

    public Double calculate() {
        while(expression.hasMoreTokens()){
            String nextToken = expression.nextToken();
            if ("+-*/".contains(nextToken)){
                operators.add(nextToken);
            } else {
                values.add(Double.parseDouble(nextToken));
            }
        }
        while (!operators.isEmpty()){
            if (values.size()<2){
                throw new RuntimeException("Invalid expression!");
            }
            var value2 = values.pop();
            var value1 = values.pop();
            switch (operators.pop()){
                case "+":
                    values.add(value1+value2);
                    break;
                case "-":
                    values.add(value1-value2);
                    break;
                case "*":
                    values.add(value1*value2);
                    break;
                case "/":
                    values.add(value1/value2);
                    break;
            }
        }
        if (values.size()!=1){
            throw new RuntimeException("Invalid expression!");
        }
        return values.get(0);
    }
}
