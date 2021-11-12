package br.com.maximatech.data.model

import com.google.gson.annotations.SerializedName

data class Pedido (
    @SerializedName("numero_ped_Rca")
    val numeroPedRca: Long,
    @SerializedName("numero_ped_erp")
    val numeroPedErp: String,
    @SerializedName("codigoCliente")
    val codigoCliente: String,
    @SerializedName("NOMECLIENTE")
    val nomecliente: String,
    @SerializedName("data")
    val data: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("critica")
    val critica: String? = null,
    @SerializedName("tipo")
    val tipo: String,
    @SerializedName("legendas")
    val legendas: List<String>? = null
)