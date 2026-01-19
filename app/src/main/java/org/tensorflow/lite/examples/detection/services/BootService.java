package org.tensorflow.lite.examples.detection.services;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import org.tensorflow.lite.examples.detection.DetectorActivity;
import org.tensorflow.lite.examples.detection.R;


public class BootService extends Service {

    long startTime;

    @SuppressLint("ForegroundServiceType")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startTime=System.currentTimeMillis();
        Log.d("TAG","startTime"+startTime);
        startForeground(1, getNotification());
        long endtime=System.currentTimeMillis();
        long diff=endtime-startTime;
        Log.e("TAG","difftime"+diff);
        Log.e("TAG","Launch Time:"+diff +" ms ("+ (diff/1000)+"sec)");
        Toast.makeText(this, "Launch Time: "+diff +" ms ("+ (diff/1000)+"sec)", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, DetectorActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
//        new Handler(Looper.getMainLooper()).postDelayed(() -> {
//
//          // stopSelf();
//        }, 7000);

        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private Notification getNotification() {
        String channelId = "boot_service_channel";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Boot Service",
                    NotificationManager.IMPORTANCE_MIN
            );
            NotificationManager manager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
        return new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.mipmap.ic_launcher_facerec_round)
                .setContentTitle("")
                .setContentText("")
                .setPriority(NotificationCompat.PRIORITY_MIN)
                .build();
    }
}



