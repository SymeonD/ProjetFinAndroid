package com.example.projetfin.ExerciceMultiplication;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projetfin.*;
import com.example.projetfin.ExerciceCalcul.ExerciceCalculActivity;
import com.example.projetfin.ExerciceCalcul.TableCalcul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class ExerciceMultiplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_multiplication);

        NumberPicker nbr_pick = findViewById(R.id.nbr_pick);
        nbr_pick.setMinValue(0);
        nbr_pick.setMaxValue(9);
    }

    public void exercice_multiplication_valider(View view){
        NumberPicker nbr_pick = findViewById(R.id.nbr_pick);
        Intent intent = new Intent(this, ExerciceCalculActivity.class);

        intent.putExtra(ExerciceCalculActivity.OPERATION, "*");
        intent.putExtra(ExerciceCalculActivity.VAL, nbr_pick.getValue());
        startActivity(intent);
    }
}