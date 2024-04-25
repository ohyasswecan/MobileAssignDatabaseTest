package com.example.assignmentdatabasedesign;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContentDAO {
    @Insert
    void insert(Content content);

    @Query("SELECT * FROM Content")
    List<Content> getAllContents();

    @Query("SELECT * FROM Content WHERE content_id = :contentId")
    Content getContentById(int contentId);

    @Update
    void update(Content content);

    @Delete
    void delete(Content content);

    @Query("DELETE FROM Content")
    void deleteAllContents();
}

