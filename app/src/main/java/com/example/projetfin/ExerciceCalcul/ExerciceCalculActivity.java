package com.example.projetfin.ExerciceCalcul;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projetfin.*;

import java.util.ArrayList;

public class ExerciceCalculActivity extends AppCompatActivity {

    TableCalcul tableCalcul;
    ArrayList<EditText> listeResultat = new ArrayList<>();
    public static final int END_REQUEST = 0;
    public static final String OPERATION = "OPERATION";
    public static final String VAL = "VAL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_calcul);

        LinearLayout linearCalcul = findViewById(R.id.linear_calc);

        String operation = getIntent().getStringExtra(OPERATION);
        int val = getIntent().getIntExtra(VAL, 0);
        TextView title = findViewById(R.id.title_calcul);

        switch(operation.charAt(0)){
            case '+':
                title.setText("Addition");
                break;
            case '-':
                title.setText("Soustraction");
                break;
            case '*':
                title.setText("Multiplication");
                break;
            case '/':
                title.setText("Division");
                break;
        }

        if(operation.charAt(0) == '*'){
            tableCalcul = new TableCalcul(operation.charAt(0), val);
        }else{
            tableCalcul = new TableCalcul(operation.charAt(0));
        }


        for(Calcul calcul : tableCalcul.getCalculs()){
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);

            TextView calculText = (TextView) linearTMP.findViewById(R.id.template_calcul);
            calculText.setText(calcul.getOperande1() + operation + calcul.getOperande2() + " = ");

            EditText resultat = (EditText) linearTMP.findViewById(R.id.template_resultat);
            resultat.setText("");
            listeResultat.add(resultat);

            linearCalcul.addView(linearTMP);
        }
    }

    public void exercice_calcul_valider(View view){
        Intent intent;
        int nb_wrong = 0;

        for (int i = 0; i < listeResultat.size(); i++){
            if(listeResultat.get(i).getText().toString().equals("") || !tableCalcul.getCalculs().get(i).isRight(Integer.parseInt(listeResultat.get(i).getText().toString()))){
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