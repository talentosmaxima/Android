package br.com.maximatech.ui.historicoPedidosScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.maximatech.R
import br.com.maximatech.core.extensions.formatDate
import br.com.maximatech.data.model.Pedido
import br.com.maximatech.databinding.ItemHistoricoPedidosBinding

class HistoricoPedidosAdapter :
    ListAdapter<Pedido, HistoricoPedidosAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoricoPedidosBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemHistoricoPedidosBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pedido) {
            binding.numeroRcaErp.text = binding.root.resources.getString(
                R.string.label_numero_rca_erp, item.numeroPedRca.toString(), item.numeroPedErp
            )
            binding.cliente.text = binding.root.resources.getString(
                R.string.label_codigo_cliente, item.codigoCliente, item.nomecliente
            )
            binding.status.text = item.status
            binding.data.text = item.data.formatDate()
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Pedido>() {
    override fun areItemsTheSame(oldItem: Pedido, newItem: Pedido) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Pedido, newItem: Pedido) = oldItem.numeroPedErp == newItem.numeroPedErp
}