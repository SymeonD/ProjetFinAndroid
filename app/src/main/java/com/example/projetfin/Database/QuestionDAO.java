package com.example.projetfin.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionDAO {

    @Query("SELECT * FROM questions")
    List<User> getAll();

    @Insert
    long insert(Question question);

    @Insert
    long[] insertAll(Question... questions);

    @Delete
    void delete(Question question);

    @Update
    void update(Question question);

}