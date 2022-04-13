package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final String expression;
    private List<Integer> values = new ArrayList<>();
    public Calculator(String content){
        expression = content;
    }

    public int calculate() {
        for (var value: expression.split("[+*]")){
            values.add(Integer.parseInt(value));
        }
        if (expression.contains("+")) {
            return values.get(0) + values.get(1);
        }
        return values.get(0) * values.get(1);
    }
}
