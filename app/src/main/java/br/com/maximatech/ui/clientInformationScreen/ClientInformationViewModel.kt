package br.com.maximatech.ui.clientInformationScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.maximatech.data.model.Cliente
import br.com.maximatech.data.model.Contato
import br.com.maximatech.data.retrofit.repositories.RepositoryFactory
import kotlinx.coroutines.launch

class ClientInformationViewModel(private val context: Application) : AndroidViewModel(context) {

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

    fun sampleClient(fieldMessage: String): Cliente {
        return Cliente(
            id = 999,
            codigo = fieldMessage,
            razaoSocial = fieldMessage,
            nomeFantasia = fieldMessage,
            cnpj = fieldMessage,
            ramoAtividade = fieldMessage,
            endereco = fieldMessage,
            status = fieldMessage,
            listOf(
                Contato(
                    nome = fieldMessage,
                    telefone = fieldMessage,
                    celular = fieldMessage,
                    conjuge = fieldMessage,
                    tipo = fieldMessage,
                    time = fieldMessage,
                    email = fieldMessage,
                    dataNascimento = fieldMessage,
                    dataNascimentoConjuge = fieldMessage
                )
            )
        )
    }

    enum class State { LOADING, ERROR, SUCCESS }
}
