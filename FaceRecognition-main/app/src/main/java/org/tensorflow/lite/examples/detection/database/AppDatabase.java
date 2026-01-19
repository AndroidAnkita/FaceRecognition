package org.tensorflow.lite.examples.detection.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import org.tensorflow.lite.examples.detection.Attendancedatabase.AttendanceDao;
import org.tensorflow.lite.examples.detection.Attendancedatabase.AttendanceEntity;

@Database(entities = {UserEntity.class, AttendanceEntity.class}, version =4)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();
    public abstract AttendanceDao attendanceDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "face_db"
            ).fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}

