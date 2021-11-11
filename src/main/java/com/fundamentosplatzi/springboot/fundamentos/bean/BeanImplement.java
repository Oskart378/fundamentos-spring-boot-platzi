package com.fundamentosplatzi.springboot.fundamentos.bean;

public class BeanImplement implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola desde mi implementacion propia de mi bean");
    }
}
