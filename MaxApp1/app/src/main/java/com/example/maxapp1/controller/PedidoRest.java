package com.example.maxapp1.controller;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maxapp1.dao.BDPedido;
import com.example.maxapp1.interfaces.PedidoInterface;
import com.example.maxapp1.modelo.Pedido;
import com.example.maxapp1.modelo.Pedidos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PedidoRest extends AppCompatActivity {
    private final   Context context;
    public PedidoRest(Context context) {
        this.context = context;

    }
    public  Pedidos  getBuscarPedido(){
        return buscarPedido();
    }

    private Pedidos buscarPedido() {
        BDPedido bdPedido= new BDPedido(context);
        return bdPedido.buscar();

    }

    public Pedido[]  buscarPedidoWeb(){


        final Pedidos[] pedidos = new Pedidos[1];
        Gson gson = new GsonBuilder().registerTypeAdapter(Pedido.class,new PedidoDeserialize()).create();
        String Api = "https://private-anon-dbb28d1a0a-maximatech.apiary-mock.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();


        PedidoInterface pedidoInterface = retrofit.create(PedidoInterface.class);
        Call<Pedidos> call = pedidoInterface.buscarPedidos();

        call.enqueue(new Callback<Pedidos>() {
            @Override
            public void onResponse(Call<Pedidos> call, Response<Pedidos> response) {
                pedidos[0] = response.body();
                BDPedido b = new BDPedido(context);

                b.inserirPedidos( pedidos[0] );
            }

            @Override
            public void onFailure(Call<Pedidos> call, Throwable t) {
                 Log.e("PedidoInterface   ", "Erro ao buscar o pedido:" +t.getMessage() );


            }
        });

        return null;
    }

}
