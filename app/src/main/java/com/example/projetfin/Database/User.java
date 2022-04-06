package com.example.projetfin.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String firstName;
    private String lastName;
    private int score;

    /*
     * Getters and Setters
     * */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name_) {
        this.firstName = first_name_;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name_) {
        this.lastName = last_name_;
    }

    public void setScore(int score_) {
        this.score = score_;
    }

    public int getScore(){
        return this.score;
    }
}
