package com.example.maxapp1.controller;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maxapp1.dao.BDCliente;
import com.example.maxapp1.interfaces.ClienteInterface;
import com.example.maxapp1.modelo.Cliente;
import com.example.maxapp1.recursos.GerarAviso;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteRest extends AppCompatActivity {
    private final   Context context;
    public ClienteRest(Context context) {
        this.context = context;

    }
    public Cliente getBuscarCliente(){
        return buscarCliente();
    }
    private Cliente buscarCliente() {
        BDCliente bdCliente= new BDCliente(context);
        return bdCliente.buscar();

    }

    public Cliente buscarClienteWeb(){


        final Cliente[] cliente = new Cliente[1];
        Gson gson = new GsonBuilder().registerTypeAdapter(Cliente.class,new ClienteDeserialize()).create();
        String Api = "https://private-anon-dbb28d1a0a-maximatech.apiary-mock.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();


        ClienteInterface clienteInterface = retrofit.create(ClienteInterface.class);
        Call<Cliente> call = clienteInterface.buscarCliente();

        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                cliente[0] = response.body();
                BDCliente b = new BDCliente(context);
                b.inserirCliente(cliente[0]);
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Log.e("ClienteInterface   ", "Erro ao buscar o cliente:" + t.getMessage());
            }
        });
        Date data = new Date ();
        data.setTime (data.getTime () + 900000);
        GerarAviso avisox = new GerarAviso (context);
        avisox.AgendarNotificacao (data,"MaxApp","Notificação importante!" ,152260);

        return null;
    }

}
