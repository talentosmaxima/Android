package com.example.maxapp1.recursos;

import static android.content.Context.ALARM_SERVICE;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.AlarmManagerCompat;

import java.util.Calendar;
import java.util.Date;

public class GerarAviso {
    private Context context;
    public GerarAviso (Context context) {
        this.context=context;
    }


    public void AgendarNotificacao(Date data, String titulo, String msg, int id) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        // Prepara o intent que deverá ser lançado na hora definida
   Intent intent = new Intent(context, CriarNotificacao.class);
        intent.putExtra("titulo", titulo);
        intent.putExtra("aviso", msg);
        intent.putExtra("id", id);
        Alarmar( calendar ,  id, intent);


    }





    public void Alarmar( Calendar calendar , int id,Intent intent) {
        PendingIntent pendingIntent = PendingIntent.getBroadcast (context, id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Regista o alerta no sistema.
        AlarmManager alarmManager;
        alarmManager = (AlarmManager) context.getSystemService (ALARM_SERVICE);
        alarmManager.set (AlarmManager.RTC, calendar.getTimeInMillis (), pendingIntent);
        AlarmManagerCompat alarmManagerCompat = null;
        alarmManagerCompat.setAlarmClock (alarmManager, calendar.getTimeInMillis (), pendingIntent, pendingIntent);
        Log.e("A", "Avisado :" + calendar.get(Calendar.HOUR)+":"+ calendar.get(Calendar.MINUTE));

    }




}
