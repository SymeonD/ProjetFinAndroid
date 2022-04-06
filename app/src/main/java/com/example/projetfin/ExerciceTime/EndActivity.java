package com.example.projetfin.ExerciceTime;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projetfin.*;
import com.example.projetfin.Database.DatabaseClient;
import com.example.projetfin.Database.User;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    public static final String SCORE = "SCORE";
    private DatabaseClient mDb;
    private User user;
    int userId;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        score = getIntent().getIntExtra(SCORE, 0);
        TextView text_score = findViewById(R.id.score_end);
        text_score.setText(String.valueOf(score));

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());
        userId = getIntent().getIntExtra("USERID", 0);
        setUserScore();
    }

    public void onMenu(View view){
        setResult(21);
        super.finish();
    }

    private void setUserScore() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        user = ((MyApplication) this.getApplication()).getSomeVariable();
        user.setScore(user.getScore() + score);
        class GetTasks extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                mDb.getAppDatabase().userDao().update(user);
                return null;
            }
        }

        GetTasks gt = new GetTasks();
        gt.execute();
    }
}