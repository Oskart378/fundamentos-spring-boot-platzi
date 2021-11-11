package com.fundamentosplatzi.springboot.fundamentos.bean;

import com.fundamentosplatzi.springboot.fundamentos.Enums.OperationCodes;

public class CalculatorBeanImplementation implements CalculatorBean{

    @Override
    public int ExecuteOperation(OperationCodes operation, int a, int b) {

        switch (operation){
            case ADD: return a + b;
            case SUBTRACT: return a - b;
            case MULTIPLY: return a * b;
            default: return a / b;
        }
    }
}
