package br.com.maximatech.data.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("cliente")
    val cliente: Cliente
)