package br.com.maximatech.data.retrofit.services


import br.com.maximatech.data.retrofit.responses.ClientResponse
import br.com.maximatech.data.retrofit.responses.OrderResponse
import retrofit2.http.GET

interface ApiServices {
    @GET("cliente")
    suspend fun getClient(): ClientResponse
    @GET("pedido")
    suspend fun getOrder(): OrderResponse
}