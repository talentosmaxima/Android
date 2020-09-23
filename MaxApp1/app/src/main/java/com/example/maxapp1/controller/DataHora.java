package com.example.maxapp1.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataHora {

    public DataHora() {
    }

    public String getDataHora(){


        SimpleDateFormat formatar = new SimpleDateFormat("dd-MM-yyyy_HH:mm");

        Calendar dataaux;
        dataaux = Calendar.getInstance();
        dataaux.setTime(new Date());

        dataaux.set(Calendar.YEAR,dataaux.get(Calendar.YEAR));
        dataaux.set(Calendar.MONTH,dataaux.get(Calendar.MONTH));
        dataaux.set(Calendar.DAY_OF_MONTH,dataaux.get(Calendar.DAY_OF_MONTH));
        dataaux.set(Calendar.HOUR_OF_DAY,dataaux.get(Calendar.HOUR_OF_DAY));
        dataaux.set(Calendar.MINUTE,dataaux.get(Calendar.MINUTE));

        int diax=dataaux.get(Calendar.DAY_OF_MONTH);
        int mesx = dataaux.get(Calendar.MONTH);
        int anox = dataaux.get(Calendar.YEAR);
        int horax = dataaux.get(Calendar.HOUR_OF_DAY);
        int minutox = dataaux.get(Calendar.MINUTE);;

        return ""+ diax+"/"+(mesx+1)+"/"+anox+"  "+horax+":"+minutox;


    }

}
