package com.example.projetfin.ExerciceMultiplication;

import java.util.ArrayList;

public class TableMultiplications {
    public ArrayList<Multiplication> multiplications = new ArrayList<>();
    int val;

    public TableMultiplications(int val_){
        val = val_;
        for(int i = 1; i <= 10; i++){
            multiplications.add(new Multiplication(i, val));
        }
    }

    public ArrayList<Multiplication> getMultiplications(){
        return multiplications;
    }

    public int getSize(){
        return multiplications.size();
    }
}
