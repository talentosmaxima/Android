package com.example.maxapp1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.maxapp1.controller.PedidoRest;
import com.example.maxapp1.modelo.Pedido;
import com.example.maxapp1.modelo.Pedidos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BDPedido {

    private SQLiteDatabase db;
    private  Context context;
    public BDPedido(Context context) {
        ConectionDB aux = new ConectionDB(context);
        this.context = context;
        db = aux.getWritableDatabase();

    }

    public Long getId() {

        Cursor cursor = db.rawQuery("SELECT numero_ped_Rca FROM pedido ORDER BY numero_ped_Rca DESC LIMIT 1;", null);
        cursor.moveToNext();
        cursor.close();

        return cursor.getLong(0);
    }

    public void inserirPedidos(Pedidos pedidos) {
 Pedido[]lista=pedidos.getPedidos();

        for (Pedido pedido:lista ) {

            ContentValues valores = new ContentValues();
            valores.put("numero_ped_Rca", pedido.getNumero_ped_Rca());
            valores.put("numero_ped_erp", pedido.getNumero_ped_erp());
            valores.put("codigoCliente", pedido.getCodigoCliente());
            valores.put("NOMECLIENTE", pedido.getNOMECLIENTE());
            valores.put("data", pedido.getData().getTime());
            valores.put("status", pedido.getStatus());
            valores.put("critica", pedido.getCritica());
            valores.put("tipo", pedido.getTipo());
            String legendas="";
            if (pedido.getLegendas() != null) {
                for (int i = 0; i < pedido.getLegendas().length; i++) {
                    legendas = legendas + pedido.getLegendas()[i] + " ";

                }
            }
            valores.put("legendas", legendas);

            db.insert("pedido", null, valores);

        }

    }



    public Pedidos buscar() {
        boolean tem;
        Pedidos pedidos=null;
        Pedido[] lista = new Pedido[0];
        Cursor cursor = db.rawQuery("SELECT p.numero_ped_Rca,p.numero_ped_erp, p.codigoCliente,p.NOMECLIENTE, p.data, p.status,p.critica,p.tipo,p.legendas " +
                " FROM pedido p ", null);
        cursor.moveToNext();
        tem = cursor.getCount() > 0;


        cursor.moveToFirst();


        if (tem) {

             pedidos=new Pedidos();

            List<Pedido> plist = new ArrayList<>();
            Pedido p = null;

            do {

                p = new Pedido();
                p.setNumero_ped_Rca(cursor.getLong(0));
                p.setNumero_ped_erp(cursor.getString(1));
                p.setCodigoCliente(cursor.getString(2));
                p.setNOMECLIENTE(cursor.getString(3));

                Date date = new Date();
                date.setTime(Long.valueOf(cursor.getString(4)));
                p.setData(date);
                p.setStatus(cursor.getString(5));
                p.setCritica(cursor.getString(6));
                p.setTipo(cursor.getString(7));
                String[] legendas = cursor.getString(8).split(" ");

                p.setLegendas(legendas);
                 plist.add(p);

            } while (cursor.moveToNext ());
            lista=plist.toArray(lista);
            pedidos.setPedidos(lista);

            cursor.close();

        } else {
            if (Conectado.estaConectado) {
                PedidoRest cr = new PedidoRest(context);
                 lista=cr.buscarPedidoWeb();

            } else {
                Toast.makeText(context, "Não ha conexão com a internet", Toast.LENGTH_LONG).show();

            }
        }

        return pedidos;


    }

}

