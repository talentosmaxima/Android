package com.example.maxapp1.interfaces;

 import com.example.maxapp1.modelo.Cliente;

 import retrofit2.Call;
 import retrofit2.http.GET;

public interface ClienteInterface {
    @GET("android/cliente")
    Call<Cliente> buscarCliente();


}
