package com.example.maxapp1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.maxapp1.controller.ClienteRest;
import com.example.maxapp1.modelo.Cliente;
import com.example.maxapp1.modelo.Contatos;
import com.example.maxapp1.recursos.Mascara;


public class BDCliente {

    private SQLiteDatabase db;
    private  Context context;
    public BDCliente(Context context) {
        ConectionDB aux = new ConectionDB(context);
        this.context = context;
        db = aux.getWritableDatabase();

    }

    public Long getId() {

        Cursor cursor = db.rawQuery("SELECT _id FROM cliente ORDER BY _id DESC LIMIT 1;", null);
        cursor.moveToNext();
        cursor.close();

        return cursor.getLong(0);
    }

    public void inserirCliente(Cliente cliente) {

        ContentValues valores = new ContentValues();
        valores.put("id", cliente.getId());
        valores.put("codigo", cliente.getCodigo());
        valores.put("razao_social", cliente.getRazao_social());
        valores.put("nomeFantasia", cliente.getNomeFantasia());
        valores.put("cnpj", cliente.getCnpj());
        valores.put("ramo_atividade", cliente.getRamo_atividade());
        valores.put("endereco", cliente.getEndereco());
        valores.put("status", cliente.getStatus()  );


        ContentValues valoresContatos = new ContentValues();
        valoresContatos.put("id_cliente", cliente.getId());
        valoresContatos.put("nome", cliente.getContatos()[0].getNome());
        valoresContatos.put("telefone", cliente.getContatos()[0].getTelefone());
        valoresContatos.put("celular", cliente.getContatos()[0].getCelular());
        valoresContatos.put("conjuge", cliente.getContatos()[0].getConjuge());
        valoresContatos.put("tipo", cliente.getContatos()[0].getTipo());
        valoresContatos.put("time", cliente.getContatos()[0].getTime());
        valoresContatos.put("e_mail", cliente.getContatos()[0].getE_mail());
        valoresContatos.put("data_nascimento", cliente.getContatos()[0].getData_nascimento() );
        valoresContatos.put("data_nascimentoConjuge", cliente.getContatos()[0].getDataNascimentoConjuge());



        db.insert("cliente", null, valores);
        db.insert("contatos", null, valoresContatos);



    }



    public Cliente buscar() {
        boolean tem;
        Cliente c=null ;
        Cursor cursor = db.rawQuery("SELECT c.id,c.codigo, c.razao_social,c.nomeFantasia, c.cnpj, c.ramo_atividade,c.endereco,c.status," +
                "ct.id_cliente, ct.nome, ct.telefone,ct.celular,ct.conjuge,ct.tipo,ct.time,ct.e_mail,ct.data_nascimento," +
                "ct.data_nascimentoConjuge FROM cliente c INNER JOIN contatos ct ON  c.id = ct.id_cliente", null);
        cursor.moveToNext();
        tem = cursor.getCount() > 0;

        if(tem) {
            c = new Cliente();
            c.setId(cursor.getString(0));
            c.setCodigo(cursor.getString(1));
            c.setRazao_social(cursor.getString(2));
            c.setNomeFantasia(cursor.getString(3));
            c.setCnpj(cursor.getString(4));
            c.setRamo_atividade(cursor.getString(5));
            c.setEndereco(cursor.getString(6));
            c.setStatus(cursor.getString(7));

            Contatos ct = new Contatos();
            ct.setNome(cursor.getString(9));
            ct.setTelefone(cursor.getString(10));


            Mascara formatarFone = new Mascara();

            String cel = formatarFone.Mascara("(##)#####-####",cursor.getString(11));

            ct.setCelular(cel);
            ct.setConjuge(cursor.getString(12));
            ct.setTipo(cursor.getString(13));
            ct.setTime(cursor.getString(14));
            ct.setE_mail(cursor.getString(15));
            ct.setData_nascimento(cursor.getString(16));
            ct.setDataNascimentoConjuge(cursor.getString(17));
            c.setContatosL(ct);

            cursor.close();

        }else {
            if(Conectado.estaConectado){
                ClienteRest cr = new ClienteRest(context);
                c= cr.buscarClienteWeb();

            }
            else {
                Toast.makeText(context,"Não ha conexão com a internet",Toast.LENGTH_LONG).show();

            }
        }

        return c;

    }

}

