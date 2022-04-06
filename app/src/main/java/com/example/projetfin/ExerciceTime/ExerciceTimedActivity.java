package com.example.projetfin.ExerciceTime;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.projetfin.*;
import com.example.projetfin.ExerciceCalcul.Calcul;
import com.example.projetfin.ExerciceCalcul.FelicitationActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.Random;

public class ExerciceTimedActivity extends AppCompatActivity {

    public static final int END_REQUEST = 0;
    Calcul calcul;
    Random r;
    EditText editCalcul;
    TextView textCalcul;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_timed);
        Intent intent = new Intent(this, EndActivity.class);

        //Creation of the calcul
        editCalcul = findViewById(R.id.edit_calcul);
        textCalcul = findViewById(R.id.text_calcul);
        r = new Random();
        calcul = new Calcul(r.nextInt((100 - 0) +1), r.nextInt((100 - 0) +1), '+');
        textCalcul.setText(calcul.getOperande1() + " + " + calcul.getOperande2() + " = ");
        editCalcul.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editCalcul.getText().toString().equals("")){
                    onNext(Integer.valueOf(editCalcul.getText().toString()));
                }
            }
        });

        //Initialisation of the timer
        TextClock textClock = findViewById(R.id.text_clock);
        textClock.setText("00");
        new CountDownTimer(60000, 100) {
            public void onTick(long millisUntilFinished) {
                textClock.setText(String.valueOf(millisUntilFinished / 1000));
            }
            public void onFinish() {
                intent.putExtra("SCORE", score);
                startActivityForResult(intent, END_REQUEST);
            }
        }.start();

    }

    public void onNext(int val){
        r = new Random();
        if(calcul.isRight(val)){
            calcul = new Calcul(r.nextInt((100 - 0) +1), r.nextInt((100 - 0) +1), '+');
            textCalcul.setText(calcul.getOperande1() + " + " + calcul.getOperande2() + " = ");
            editCalcul.setText("");
            score++;
        }
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