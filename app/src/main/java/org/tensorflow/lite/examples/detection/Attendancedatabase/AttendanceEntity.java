package org.tensorflow.lite.examples.detection.Attendancedatabase;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "attendance")
public class AttendanceEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public int userId;
    public String date;// yyyy-MM-dd
    public String time;// yyyy-MM-dd

    public AttendanceEntity(int userId, String date, String time) {
        this.userId = userId;
        this.date = date;
        this.time = time;
    }
}
