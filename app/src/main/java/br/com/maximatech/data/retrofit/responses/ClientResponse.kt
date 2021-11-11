package br.com.maximatech.data.retrofit.responses

import br.com.maximatech.data.model.Cliente
import com.google.gson.annotations.SerializedName

data class ClientResponse(
    @SerializedName("cliente")
    val cliente: Cliente
)