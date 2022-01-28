package com.example.maxapp1.recursos;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.maxapp1.R;
import com.example.maxapp1.view.MainActivity;

import java.util.Date;


public class CriarNotificacao extends BroadcastReceiver{

    private    Uri uri ;
    public static    Notification notification;
    public static    int id;
    private String aviso;
    private Context context;
    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent paramIntent) {
        this.context= context;
        int id = paramIntent.getExtras().getInt("id");
        son(paramIntent);
                this.id = id;
        Date data = new Date ();

        data.setTime (data.getTime () + 900000);
        GerarAviso avisox = new GerarAviso (context);

        avisox.AgendarNotificacao (data,"MaxApp","Notificação importante!" ,152260);





    }


@SuppressLint("WrongConstant")
@RequiresApi(api = Build.VERSION_CODES.O)
private void son(Intent paramIntent){


    NotificationManager note = (NotificationManager) context.getSystemService (context.NOTIFICATION_SERVICE);
    PendingIntent pendingIntent;
    pendingIntent = PendingIntent.getActivity (context, 0, new Intent (context,
            MainActivity.class), 0);



    NotificationCompat.InboxStyle estilo = new NotificationCompat.InboxStyle ();
     aviso = paramIntent.getExtras ().getString ("aviso");

    String[] descri;
    try {
        descri = new String[(aviso.length () / 40) + 1];
    } catch (Exception e) {

        descri = new String[0];


    }
    String aux = "";
    int j = 0;
    for (int i = 0; i < aviso.length (); i++) {
        aux += aviso.charAt (i);
        if (aux.length () == 40) {
            descri[j] = aux;
            estilo.addLine (descri[j]);
            aux = "";
            j++;
        }

    }
    descri[j] = aux;
    estilo.addLine (descri[j]);


    NotificationManager notificationManager = (NotificationManager) context.getSystemService (Context.NOTIFICATION_SERVICE);

    NotificationCompat.Builder builder = null;
    int importance = NotificationManager.IMPORTANCE_MAX;
    NotificationChannel notificationChannel = new NotificationChannel ("ID", "Aviso", importance);

    notificationManager.createNotificationChannel (notificationChannel);


    builder = new NotificationCompat.Builder (context, notificationChannel.getId ());

    builder.setTicker ("Aviso")
            .setContentTitle (paramIntent.getExtras ().getString ("titulo"))
            .setStyle (estilo)
            .setSmallIcon (R.drawable.ic_maxima_ferramentas)
            .setVisibility (Notification.VISIBILITY_PUBLIC)
            .setContentIntent (pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

    notification = builder.build ();
    notification.flags = Notification.FLAG_NO_CLEAR | Notification.FLAG_AUTO_CANCEL;




    note.notify (id, notification);
}



}