package br.com.maximatech.data.model

import com.google.gson.annotations.SerializedName

data class Cliente (
    @SerializedName("id")
    val id: Long,
    @SerializedName("codigo")
    val codigo: String,
    @SerializedName("razao_social")
    val razaoSocial: String,
    @SerializedName("nomeFantasia")
    val nomeFantasia: String,
    @SerializedName("cnpj")
    val cnpj: String,
    @SerializedName("ramo_atividade")
    val ramoAtividade: String,
    @SerializedName("endereco")
    val endereco: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("contatos")
    val contatos: List<Contato>
)