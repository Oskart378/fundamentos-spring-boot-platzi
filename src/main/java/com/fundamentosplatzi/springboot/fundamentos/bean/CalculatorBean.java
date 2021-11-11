package com.fundamentosplatzi.springboot.fundamentos.bean;

import com.fundamentosplatzi.springboot.fundamentos.Enums.OperationCodes;

public interface CalculatorBean {

    int ExecuteOperation(OperationCodes operation, int a, int b);
}
