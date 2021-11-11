package br.com.maximatech.core.extensions

fun String?.checkIsNullOrBlank(): String{
    return if(this.isNullOrBlank()){
        "Não informado"
    } else {
        this
    }
}