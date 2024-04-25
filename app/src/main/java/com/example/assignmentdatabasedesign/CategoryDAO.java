package com.example.assignmentdatabasedesign;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoryDAO {
    @Insert
    void insert(Category category);

    @Query("SELECT * FROM Category")
    List<Category> getAllCategories();

    @Query("SELECT * FROM Category WHERE category_id = :categoryId")
    Category getCategoryById(int categoryId);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

    @Query("DELETE FROM Category")
    void deleteAllCategories();
}