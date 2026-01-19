package org.tensorflow.lite.examples.detection.Attendancedatabase;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AttendanceDao {

    @Insert
    void insert(AttendanceEntity attendance);

    @Query("SELECT * FROM attendance WHERE userId=:userId AND date=:date")
    int isAttendanceMarked(int userId, String date);

    @Query(
            "SELECT u.name, a.date, a.time " +
                    "FROM attendance a " +
                    "INNER JOIN users u ON a.userId = u.id " +
                    "ORDER BY a.date DESC, a.time DESC"
    )
    List<AttendanceDetails> getAttendanceDetails();
}
