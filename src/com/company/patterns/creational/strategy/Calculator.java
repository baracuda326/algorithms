package com.company.patterns.creational.strategy;

import com.company.patterns.creational.strategy.operations.Add;
import com.company.patterns.creational.strategy.operations.Divide;
import com.company.patterns.creational.strategy.operations.Multiply;
import com.company.patterns.creational.strategy.operations.Operations;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Calculator {
    private Map<String, Operations> operationsMap;

    public Calculator() {
        operationsMap = new HashMap<>();
        operationsMap.put("add", new Add());
        operationsMap.put("multiply", new Multiply());
        operationsMap.put("divide", new Divide());
    }

    public int calculate(int a, int b, String operator) {
        Operations operations = Optional.ofNullable(operationsMap.get(operator)).orElseThrow(() -> new IllegalArgumentException());
        return operations.execute(a,b);
    }
}
