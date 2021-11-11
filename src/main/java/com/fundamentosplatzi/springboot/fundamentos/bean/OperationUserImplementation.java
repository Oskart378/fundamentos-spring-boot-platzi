package com.fundamentosplatzi.springboot.fundamentos.bean;

import com.fundamentosplatzi.springboot.fundamentos.Enums.OperationCodes;

public class OperationUserImplementation implements OperationUser{

    private CalculatorBean calculatorBean;

    public OperationUserImplementation(CalculatorBean calculatorBean){
        this.calculatorBean = calculatorBean;
    }

    @Override
    public void printEveryOperation(int a, int b) {
        System.out.printf("The sum of %d and %d is " +
                calculatorBean.ExecuteOperation(OperationCodes.ADD, a ,b) + "\n", a , b);
        System.out.printf("The subtraction of %d and %d is " +
                calculatorBean.ExecuteOperation(OperationCodes.SUBTRACT, a ,b)+ "\n",a ,b);
        System.out.printf("The product of %d and %d is " +
                calculatorBean.ExecuteOperation(OperationCodes.MULTIPLY, a ,b)+ "\n", a , b);
        System.out.printf("The division of %d and %d is " +
                calculatorBean.ExecuteOperation(OperationCodes.DIVIDE, a ,b) + "\n",a ,b);
    }
}
