package com.example.projetfin.ExerciceMultiplication;

public class Multiplication {
    public int operande1;
    public int operande2;

    public Multiplication(int a, int b){
        this.operande1 = a;
        this.operande2 = b;
    }

    public int getOperande1(){
        return operande1;
    }

    public int getOperande2(){
        return operande2;
    }

    public boolean isRight(int val){
        return val == operande1*operande2;
    }
}
