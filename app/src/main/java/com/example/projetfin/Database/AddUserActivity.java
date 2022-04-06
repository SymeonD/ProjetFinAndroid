package com.example.projetfin.Database;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetfin.*;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {

    private DatabaseClient mDb;

    private EditText editFirstNameView;
    private EditText editLastNameView;
    private Button saveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        editFirstNameView = findViewById(R.id.editFirstName);
        editLastNameView = findViewById(R.id.editLastName);
        saveView = findViewById(R.id.button_save);

        // Associer un événement au bouton save
        saveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();
            }
        });
    }

    private void saveUser(){

        // Récupérer les informations contenues dans les vues
        final String sFirstName = editFirstNameView.getText().toString().trim();
        final String sLastName = editLastNameView.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (sFirstName.isEmpty()) {
            editFirstNameView.setError("Task required");
            editFirstNameView.requestFocus();
            return;
        }

        if (sLastName.isEmpty()) {
            editLastNameView.setError("Desc required");
            editLastNameView.requestFocus();
            return;
        }

        class SaveUser extends AsyncTask<Void, Void, User> {
            @Override
            protected User doInBackground(Void... voids) {

                // creating a task
                User user = new User();
                user.setFirstName(sFirstName);
                user.setLastName(sLastName);
                user.setScore(0);

                // adding to database
                long id = mDb.getAppDatabase()
                        .userDao()
                        .insert(user);

                // mettre à jour l'id de la tache
                // Nécessaire si on souhaite avoir accès à l'id plus tard dans l'activité
                user.setId(id);


                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                // Quand la tache est créée, on arrête l'activité AddTaskActivity (on l'enleve de la pile d'activités)
                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        SaveUser st = new SaveUser();
        st.execute();
    }
}