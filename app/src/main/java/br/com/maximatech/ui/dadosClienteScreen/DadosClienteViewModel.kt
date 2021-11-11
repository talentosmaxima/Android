package br.com.maximatech.ui.dadosClienteScreen

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.maximatech.data.model.Cliente
import br.com.maximatech.data.model.Contato
import br.com.maximatech.ui.State
import br.com.maximatech.data.retrofit.repositories.RepositoryFactory
import kotlinx.coroutines.launch

class DadosClienteViewModel(private val context: Application) : AndroidViewModel(context) {

    val client = MutableLiveData<Cliente>()
    val apiRequestState = MutableLiveData<State>()

    fun getData() {
        apiRequestState.postValue(State.LOADING)
        viewModelScope.launch {
            try {
                val retrofitInstance =
                    RepositoryFactory.getApiRepository()
                val responBody = retrofitInstance.getClient()

                client.postValue(responBody.cliente)
                apiRequestState.postValue(State.SUCCESS)
            } catch (e: Exception) {
                apiRequestState.postValue(State.ERROR)
            }
        }
    }
}
