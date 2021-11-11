package br.com.maximatech.ui.historicoPedidosScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.maximatech.data.model.Pedido
import br.com.maximatech.data.retrofit.repositories.RepositoryFactory
import br.com.maximatech.ui.State
import kotlinx.coroutines.launch

class HistoricoPedidosViewModel: ViewModel() {

    val pedidosList = MutableLiveData<List<Pedido>>()
    val apiRequestState = MutableLiveData<State>()

    fun getData() {
        apiRequestState.postValue(State.LOADING)
        viewModelScope.launch {
            try {
                val retrofitInstance =
                    RepositoryFactory.getApiRepository()
                val responBody = retrofitInstance.getOrder()

                pedidosList.postValue(responBody.pedidos)
                apiRequestState.postValue(State.SUCCESS)
            } catch (e: Exception) {
                apiRequestState.postValue(State.ERROR)
            }
        }
    }
}