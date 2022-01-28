package com.example.maxapp1.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import java.io.File;
import java.util.Calendar;
import java.util.Date;


public class ConectionDB extends SQLiteOpenHelper {
    private static final String nomeDB = "max";
    private static final int vers = 1;
    private Context context;


    public ConectionDB(Context context) {
        super(context, nomeDB, null, vers);
        this.context = context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table cliente(" +
                "id text  ," +
                "codigo text  ," +
                "razao_social text  ," +
                "nomeFantasia text ," +
                "cnpj text  ," +
                "ramo_atividade text  ," +
                "endereco text  ," +
                "status text  );");


        db.execSQL("create table contatos(" +
                "_id integer primary key autoincrement," +
                "id_cliente text ," +
                "nome text ," +
                "telefone text ," +
                "celular text ," +
                "conjuge text ," +
                "tipo text," +
                "time text ," +
                "e_mail text ," +
                "data_nascimento text ," +
                "data_nascimentoConjuge text );");


        db.execSQL("create table pedido(" +
                "numero_ped_Rca integer  ," +
                "numero_ped_erp text  ," +
                "codigoCliente text  ," +
                "NOMECLIENTE text ," +
                "data text  ," +
                "status text  ," +
                "critica text  ," +
                "legendas text  ," +
                "tipo text  );");

        db.execSQL("create table legenda(" +
                "numero_ped_Rca integer  ," +
                "legenda text );");


        Calendar calendar = Calendar.getInstance();
        Date data = new Date();
        try {
            calendar.setTime(data);
        } catch (Exception er) {
            er.printStackTrace();
        }


    }
    @Override
    public void onOpen(SQLiteDatabase database) {
        super.onOpen(database);
        if(Build.VERSION.SDK_INT >= 28)
        {
            File dbshm = new File(database.getPath() + "-shm");
            File dbwal = new File(database.getPath()+ "-wal");
            if (dbshm.exists()) {
                dbshm.delete();
            }
            if (dbwal.exists()) {
                dbwal.delete();
            }


            database.disableWriteAheadLogging();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}


}
