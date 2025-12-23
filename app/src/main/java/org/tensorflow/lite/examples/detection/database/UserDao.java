package org.tensorflow.lite.examples.detection.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(UserEntity user);

    @Query("SELECT * FROM users")
    List<UserEntity> getAllUsers();

    @Query("SELECT * FROM users WHERE name = :name LIMIT 1")
    UserEntity getUserByName(String name);
}

