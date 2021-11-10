package br.com.maximatech.data.model

import com.google.gson.annotations.SerializedName

data class Contato (
    @SerializedName("nome")
    val nome: String,
    @SerializedName("telefone")
    val telefone: String,
    @SerializedName("celular")
    val celular: String,
    @SerializedName("conjuge")
    val conjuge: String,
    @SerializedName("tipo")
    val tipo: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("e_mail")
    val email: String,
    @SerializedName("data_nascimento")
    val dataNascimento: String,
    @SerializedName("dataNascimentoConjuge")
    val dataNascimentoConjuge: String? = null
)