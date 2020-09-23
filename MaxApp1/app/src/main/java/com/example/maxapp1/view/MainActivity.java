package com.example.maxapp1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maxapp1.R;
import com.example.maxapp1.dao.Conectado;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
private  String version = "0.3";
private TextView informe ;
    private ImageView nuvemConexao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        Conectado conectado = new Conectado(getBaseContext());
        Drawable drawable= (conectado.conectado()) ? ResourcesCompat.getDrawable(res, R.drawable.ic_maxima_nuvem_conectado, null) :
                ResourcesCompat.getDrawable(res, R.drawable.ic_maxima_nuvem_desconectado, null);

        nuvemConexao = (ImageView) findViewById(R.id.img_on_off);
        nuvemConexao.setImageDrawable(drawable);
        informe = (TextView) findViewById(R.id.tx_version);
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(),0);
            version = String.valueOf(info.versionName);
            informe.setText("v."+version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }



    public void dadosDoCliente(View view) {
        startActivity(new Intent(getBaseContext(), MenuClientes.class));

    }
}