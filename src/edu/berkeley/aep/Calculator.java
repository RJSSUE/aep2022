package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.List;

//Understands the arithmetic expression and compute its value
public class Calculator {
    private final String expression;
    private List<Double> values = new ArrayList<>();
    public Calculator(String content){
        expression = content;
    }

    public double calculate() {
        for (var value: expression.split("[+*/-]")){
            values.add(Double.parseDouble(value));
        }
        if (expression.contains("+")) {
            return values.get(0) + values.get(1);
        } else if (expression.contains("*")) {
            return values.get(0) * values.get(1);
        } else if (expression.contains("-")) {
            return values.get(0) - values.get(1);
        } else {
            return values.get(0) / values.get(1);
        }
    }
}
