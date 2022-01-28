package com.example.maxapp1.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;

import com.example.maxapp1.R;


public class LegendasView extends AppCompatDialog {
    private AlertDialog alerta;
    private View view;
    private LayoutInflater li;

    private Button btFechar;


    public LegendasView (Context context) {
        super(context);

        li = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        //inflamos o layout alerta.xml na view
        view = li.inflate( R.layout.item_legendas, null );

        btFechar = view.findViewById( R.id.btFechar );


    }


    public AlertDialog enviarAlerta() {

        //-pegamos nossa instancia da classe



        AlertDialog.Builder builder = new AlertDialog.Builder( view.getContext() );

        builder.setView( view );
        alerta = builder.create();

        return alerta;
    }



    public Button getBtFechar() {

        return btFechar;
    }

    public void fechar(){

        alerta.dismiss();
    }


}