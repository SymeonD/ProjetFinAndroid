package com.example.projetfin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projetfin.Database.AddUserActivity;
import com.example.projetfin.Database.DatabaseClient;
import com.example.projetfin.Database.User;
import com.example.projetfin.Database.UsersAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // RETURN VALUE
    private static final int REQUEST_CODE_ADD = 0;

    // DATA
    private DatabaseClient mDb;
    private UsersAdapter adapter;
    private List<User> globUsers;

    // VIEW
    private Button buttonAdd;
    private ListView listUser;

    // BOOL
    private int userSet = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        listUser = findViewById(R.id.list_user);
        listUser.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        buttonAdd = findViewById(R.id.button_add);

        // Lier l'adapter au listView
        adapter = new UsersAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);

        // Ajouter un événement au bouton d'ajout
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ADD);
            }
        });

        // Ajouter un événement click à la listView
        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Récupération de la tâche cliquée à l'aide de l'adapter
                User user = adapter.getItem(position);
                //listUser.setItemChecked(listUser.getCheckedItemPosition(), false);
                listUser.setItemChecked(position, true);

                if(userSet != -1){
                    parent.getChildAt(userSet).setBackgroundColor(0x00000000);
                }
                parent.getChildAt(position).setBackgroundColor(Color.rgb(178, 138, 242));
                userSet = position;

                // Enable bouton commencer
                Button buttonStart = findViewById(R.id.button_start);
                if(!buttonStart.isEnabled()){
                    buttonStart.setEnabled(true);
                }

                // Message
                Toast.makeText(MainActivity.this, "Click : " + user.getFirstName(), Toast.LENGTH_SHORT).show();
            }
        });

        // Disable start button
        findViewById(R.id.button_start).setEnabled(false);
    }

    private void getUsers() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetTasks extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = mDb.getAppDatabase()
                        .userDao()
                        .getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);

                // Mettre à jour l'adapter avec la liste de taches
                adapter.clear();
                adapter.addAll(users);

                // Now, notify the adapter of the change in source
                adapter.notifyDataSetChanged();

                globUsers = users;
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        // Création d'un objet de type GetTasks et execution de la demande asynchrone
        GetTasks gt = new GetTasks();
        gt.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des taches
        getUsers();

    }

    public void onExercices(View view){

        // Création d'une intention
        Intent exercicesActivitiyIntent = new Intent(this, ExercicesActivity.class);
        ((MyApplication) this.getApplication()).setSomeVariable(globUsers.get(userSet));

        // Lancement de la demande de changement d'activité
        startActivity(exercicesActivitiyIntent);
    }
}