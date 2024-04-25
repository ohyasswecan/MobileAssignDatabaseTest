package com.example.assignmentdatabasedesign;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface OrderDAO {
    @Insert
    void insert(Order order);

    @Query("SELECT * FROM `Order`")
    List<Order> getAllOrders();

    @Query("SELECT * FROM `Order` WHERE user_id = :userId AND content_id = :contentId")
    Order getOrderByIds(int userId, int contentId);

    @Update
    void update(Order order);

    @Delete
    void delete(Order order);

    @Query("DELETE FROM `Order`")
    void deleteAllOrders();
}
