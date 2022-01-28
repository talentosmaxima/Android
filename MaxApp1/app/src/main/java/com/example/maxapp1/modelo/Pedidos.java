package com.example.maxapp1.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pedidos implements Serializable {

    @SerializedName("pedidos")
    @Expose
     Pedido[] pedidos ;


    public Pedido[] getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido[] pedidos) {
        this.pedidos = pedidos;
    }

    public Pedidos() {
    }


    @Override
    public String toString() {
        return "Pedidos{" +
                "pedidos=" + pedidos +
                '}';
    }
}
