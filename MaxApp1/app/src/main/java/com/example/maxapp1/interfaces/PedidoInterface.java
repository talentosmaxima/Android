package com.example.maxapp1.interfaces;

import com.example.maxapp1.modelo.Pedidos;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PedidoInterface {
    @GET("android/pedido")
    Call<Pedidos> buscarPedidos();


}
