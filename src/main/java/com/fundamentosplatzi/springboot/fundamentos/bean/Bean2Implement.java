package com.fundamentosplatzi.springboot.fundamentos.bean;

public class Bean2Implement implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola desde mi implementacion propia de mi bean 2");
    }
}
