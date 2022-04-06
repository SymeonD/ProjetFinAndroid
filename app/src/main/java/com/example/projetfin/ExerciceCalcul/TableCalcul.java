package com.example.projetfin.ExerciceCalcul;

import java.util.ArrayList;
import java.util.Random;

public class TableCalcul {
    public ArrayList<Calcul> calculs = new ArrayList<>();

    //Création de la table de calcul en fonction du signe
    public TableCalcul(char calcOperator, int val){
        Random r = new Random();
        switch(calcOperator){
            case '+':
                for(int i = 0; i < 10; i++){
                    calculs.add(new Calcul(r.nextInt((100 - 0) +val), r.nextInt((100 - 0) +val), '+'));
                }
                break;
            case '-':
                for(int i = 0; i < 10; i++){
                    calculs.add(new Calcul(r.nextInt((100 - 0) +val), r.nextInt((100 - 0) +1), '-'));
                }
                break;
            case '*':
                for(int i = 0; i < 10; i++){
                    calculs.add(new Calcul(i, val, '*'));
                }
                break;
            case '/':
                for(int i = 0; i < 10; i++){
                    calculs.add(new Calcul(r.nextInt((100 - 0) +val), r.nextInt((100 - 0) +val), '/'));
                }
                break;
        }

    }

    public TableCalcul(char calcOperator){
        Random r = new Random();
        switch(calcOperator){
            case '+':
                for(int i = 0; i < 10; i++){
                    calculs.add(new Calcul(r.nextInt((100 - 0) +1), r.nextInt((100 - 0) +1), '+'));
                }
                break;
            case '-':
                for(int i = 0; i < 10; i++){
                    calculs.add(new Calcul(r.nextInt((100 - 0) +1), r.nextInt((100 - 0) +1), '-'));
                }
                break;
            case '*':
                for(int i = 0; i < 10; i++){
                    calculs.add(new Calcul(r.nextInt((100 - 0) +1), r.nextInt((100 - 0) +1), '*'));
                }
                break;
            case '/':
                for(int i = 0; i < 10; i++){
                    calculs.add(new Calcul(r.nextInt((100 - 0) +1), r.nextInt((100 - 0) +1), '/'));
                }
                break;
        }

    }

    public ArrayList<Calcul> getCalculs(){
        return calculs;
    }

    public int getSize(){
        return  calculs.size();
    }
}
