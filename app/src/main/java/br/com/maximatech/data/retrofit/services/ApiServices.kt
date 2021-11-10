package br.com.maximatech.data.retrofit.services


import br.com.maximatech.data.model.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("cliente")
    suspend fun getClient(): Response
}