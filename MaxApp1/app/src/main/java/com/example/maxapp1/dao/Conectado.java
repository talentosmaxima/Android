package com.example.maxapp1.dao;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Conectado {
    private static Context context;
    public static boolean estaConectado=false;
    public Conectado(Context context) {
        this.context = context;
    }

    public static boolean conectado() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( connectivityManager != null ) {
            NetworkInfo net = connectivityManager.getActiveNetworkInfo();
            estaConectado = net != null && net.isConnected();
            return net != null && net.isConnected();
        }

        return false;
    }

}
