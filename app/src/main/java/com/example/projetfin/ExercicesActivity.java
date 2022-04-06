package com.example.projetfin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.projetfin.Database.DatabaseClient;
import com.example.projetfin.Database.User;
import com.example.projetfin.ExerciceCalcul.ExerciceCalculActivity;
import com.example.projetfin.ExerciceMultiplication.*;
import com.example.projetfin.ExerciceTime.ExerciceTimedActivity;

import java.util.List;

public class ExercicesActivity extends AppCompatActivity {

    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices);

        LinearLayout linear = findViewById(R.id.linear);

        // Récupération du DatabaseClient
        userId = getIntent().getIntExtra("USERID", 0);

        for(int i =0; i<5; i++){
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_exercice, null);

            Button titreExercice = (Button) linearTMP.findViewById(R.id.titre_exercice);
            titreExercice.setText("Exercice multiplication");

            if(i == 1){
                titreExercice.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View view){
                        onAddition(view);
                    }
                });
                titreExercice.setText("Exercice addition");
            }

            if(i == 2){
                titreExercice.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View view){
                        onSoustraction(view);
                    }
                });
                titreExercice.setText("Exercice soustraction");
            }

            if(i == 3){
                titreExercice.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View view){
                        onDivision(view);
                    }
                });
                titreExercice.setText("Exercice division");
            }

            if(i == 3){
                titreExercice.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View view){
                        onTimedExercice(view);
                    }
                });
                titreExercice.setText("Exercice chronométré");
            }

            linear.addView(linearTMP);
        }
    }

    public void onMultiplications(View view){
        Intent intent = new Intent(this, ExerciceMultiplicationActivity.class);
        intent.putExtra("USERID", userId);

        startActivity(intent);
    }

    public void onAddition(View view){
        Intent intent = new Intent(this, ExerciceCalculActivity.class);

        intent.putExtra(ExerciceCalculActivity.OPERATION, "+");
        intent.putExtra("USERID", userId);

        startActivity(intent);
    }

    public void onSoustraction(View view){
        Intent intent = new Intent(this, ExerciceCalculActivity.class);

        intent.putExtra(ExerciceCalculActivity.OPERATION, "-");
        intent.putExtra("USERID", userId);

        startActivity(intent);
    }

    public void onDivision(View view){
        Intent intent = new Intent(this, ExerciceCalculActivity.class);

        intent.putExtra(ExerciceCalculActivity.OPERATION, "/");
        intent.putExtra("USERID", userId);

        startActivity(intent);
    }

    public void onTimedExercice(View view){
        Intent intent = new Intent(this, ExerciceTimedActivity.class);
        intent.putExtra("USERID", userId);

        startActivity(intent);
    }
}