package com.example.projetfin.ExerciceCalcul;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Calcul {
    public int operande1;
    public int operande2;
    public char calcOperator;

    public Calcul(int a, int b, char op) {
        this.operande1 = a;
        this.operande2 = b;
        if(op == '+' || op == '-' || op == '*' || op == '/'){
            this.calcOperator = op;
        }
    }

    public int getOperande1() {
        return operande1;
    }

    public int getOperande2() {
        return operande2;
    }

    public char getCalcOperator(){
        return calcOperator;
    }

    public boolean isRight(int val) {
        int val2;
        switch(calcOperator){
            case '+':
                return val == operande1 + operande2;
            case '-':
                return val == operande1 - operande2;
            case '*':
                return val == operande1 * operande2;
            case '/':
                return val == operande1 / operande2;
        }
        return false;
    }
}
