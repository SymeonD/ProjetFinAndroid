package com.example.projetfin.ExerciceCalcul;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projetfin.*;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ErreurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur);
        int erreurs = getIntent().getIntExtra("NB_ERREUR", 0);
        TextView erreur_text = findViewById(R.id.exercice5_nbr);
        erreur_text.setText("Nombre d'erreurs : "+erreurs);
    }

    public void change_resp(View view){
        setResult(RESULT_OK);
        super.finish();
    }

    public void change_table(View view){
        setResult(21);
        super.finish();
    }
}