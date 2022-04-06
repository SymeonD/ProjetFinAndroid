package com.example.projetfin.Database;

import androidx.room.PrimaryKey;
import androidx.room.Entity;

@Entity(tableName = "questions")
public class Question {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String question;
    private String[] proposition;
    private String answer;

    /*
     * Getters and Setters
     * */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getProposition() {
        return proposition;
    }

    public void setProposition(String[] proposition) {
        this.proposition = proposition;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

