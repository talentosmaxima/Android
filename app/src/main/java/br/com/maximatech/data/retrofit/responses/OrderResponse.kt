package br.com.maximatech.data.retrofit.responses

import br.com.maximatech.data.model.Pedido
import com.google.gson.annotations.SerializedName

data class OrderResponse(
    @SerializedName("pedidos")
    val pedidos: List<Pedido>
)