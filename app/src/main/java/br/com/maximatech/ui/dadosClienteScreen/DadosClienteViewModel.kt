package br.com.maximatech.ui.dadosClienteScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.maximatech.R
import br.com.maximatech.core.helpers.DateHelper
import br.com.maximatech.data.model.Cliente
import br.com.maximatech.data.retrofit.repositories.RepositoryFactory
import br.com.maximatech.ui.State
import kotlinx.coroutines.launch

class DadosClienteViewModel(private val context: Application) : AndroidViewModel(context) {

    val client = MutableLiveData<Cliente>()
    val apiRequestState = MutableLiveData<State>()

    fun fetchData() {
        apiRequestState.value = State.LOADING
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

    fun getClientDataStatus(): String{
        return context.getString(
            R.string.label_data_status,
            getCurrentTime(),
           getClientStatus()
        )
    }

    private fun getCurrentTime(): String {
        return DateHelper.getCurrentDate(DATE_PATTERN)
    }

    private fun getClientStatus(): String{
        return client.value?.status ?: context.getString(R.string.undefined)
    }

    companion object{
        private const val DATE_PATTERN = "dd/MM/yyyy HH:mm"
    }
}
