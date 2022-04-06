package com.example.projetfin.ExerciceCalcul;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projetfin.R;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FelicitationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitation);
    }

    public void change_table(View view){
        setResult(21);
        super.finish();
    }

    public void change_ex(View view){
        super.finish();
        Intent intent = new Intent(this, com.example.projetfin.MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}