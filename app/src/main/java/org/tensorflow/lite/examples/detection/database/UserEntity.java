package org.tensorflow.lite.examples.detection.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String name;

    @NonNull
    public byte[] faceData;

    public UserEntity(@NonNull String name, @NonNull byte[] faceData) {
        this.name = name;
        this.faceData = faceData;
    }
}



