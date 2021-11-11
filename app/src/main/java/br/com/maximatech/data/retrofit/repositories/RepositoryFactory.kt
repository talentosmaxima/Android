package br.com.maximatech.data.retrofit.repositories

import br.com.maximatech.data.retrofit.services.ApiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryFactory {

    companion object {
        fun getApiRepository() : ApiServices = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)

        private const val BASE_URL =
            "https://private-anon-472f0978ae-maximatech.apiary-mock.com/android/"
    }
}