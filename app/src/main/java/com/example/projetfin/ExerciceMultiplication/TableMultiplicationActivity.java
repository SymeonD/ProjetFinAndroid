package com.example.projetfin.ExerciceMultiplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.projetfin.*;
import com.example.projetfin.ExerciceCalcul.ErreurActivity;
import com.example.projetfin.ExerciceCalcul.FelicitationActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TableMultiplicationActivity extends AppCompatActivity {

    TableMultiplications tableMultiplication;
    ArrayList<EditText> listeResultat = new ArrayList<>();
    public static final int END_REQUEST = 0;
    public static final String TABLE_VAL = "TABLE_VAL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int val = getIntent().getIntExtra(TABLE_VAL, 0);

        setContentView(R.layout.activity_table_multiplication);

        LinearLayout linearMulti = findViewById(R.id.linearMulti);

        tableMultiplication = new TableMultiplications(val);

        //générer la table
        for(Multiplication multiplication : tableMultiplication.getMultiplications()){
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);

            TextView calcul = (TextView) linearTMP.findViewById(R.id.template_calcul);
            calcul.setText(multiplication.getOperande1() + " x " + multiplication.getOperande2() + " = ");

            EditText resultat = (EditText) linearTMP.findViewById(R.id.template_resultat);
            resultat.setText("");
            listeResultat.add(resultat);

            linearMulti.addView(linearTMP);
        }
    }

    public void multi_valider(View view){
        Intent intent;
        int nb_wrong = 0;
        for (int i = 0; i < listeResultat.size(); i++){
            if(listeResultat.get(i).getText().toString().equals("") || !tableMultiplication.getMultiplications().get(i).isRight(Integer.parseInt(listeResultat.get(i).getText().toString()))){
                nb_wrong++;
            }
        }

        if(nb_wrong != 0){
            intent = new Intent(this, ErreurActivity.class);
            intent.putExtra("NB_ERREUR", nb_wrong);
        }else{
            intent = new Intent(this, FelicitationActivity.class);
        }

        startActivityForResult(intent, END_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == END_REQUEST) {
            if (resultCode == 21) {
                super.finish();
            }
        }
    }
}