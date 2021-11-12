package br.com.maximatech.ui.historicoPedidosScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.maximatech.R
import br.com.maximatech.core.helpers.DateHelper
import br.com.maximatech.data.model.Pedido
import br.com.maximatech.databinding.ItemHistoricoPedidosBinding
import java.util.*

class HistoricoPedidosAdapter :
    ListAdapter<Pedido, HistoricoPedidosAdapter.ViewHolder>(DiffCallback()), Filterable {

    private var list = mutableListOf<Pedido>()

    fun updateList(list: MutableList<Pedido>?) {
        this.list = list!!
        submitList(list)
    }

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
            checkCritica(item.critica)
            item.legendas?.let { checkLegendas(it) }

            binding.numeroRcaErp.text = binding.root.resources.getString(
                R.string.label_numero_rca_erp, item.numeroPedRca.toString(), item.numeroPedErp
            )

            binding.cliente.text = binding.root.resources.getString(
                R.string.label_codigo_cliente, item.codigoCliente, item.nomecliente
            )
            binding.status.text = item.status
            binding.data.text = DateHelper.formatDate(item.data)
        }

        private fun checkLegendas(legendas: List<String?>) {
            binding.legenda0.setImageDrawable(null)
            binding.legenda1.setImageDrawable(null)
            binding.legenda1.setImageDrawable(null)
            if (!legendas.isNullOrEmpty()) {
                legendas.forEach {
                    var viewToBind: ImageView? = null
                    when {
                        binding.legenda0.drawable == null -> {
                            viewToBind = binding.legenda0
                        }
                        binding.legenda1.drawable == null -> {
                            viewToBind = binding.legenda1
                        }
                        binding.legenda2.drawable == null -> {
                            viewToBind = binding.legenda2
                        }
                    }
                    when (it) {
                        "PEDIDO_SOFREU_CORTE" -> {
                            viewToBind?.setImageResource(R.drawable.ic_maxima_legenda_corte)
                        }
                        "PEDIDO_FEITO_TELEMARKETING" -> {
                            viewToBind?.setImageResource(R.drawable.ic_maxima_legenda_telemarketing)
                        }
                        "PEDIDO_CANCELADO_ERP" -> {
                            viewToBind?.setImageResource(R.drawable.ic_maxima_legenda_cancelamento)
                        }
                    }
                }
            }
        }

        private fun checkCritica(content: String?) {
            if (!content.isNullOrBlank()) {
                binding.labelCritica.visibility = View.VISIBLE
                when (content) {
                    "SUCESSO" -> {
                        binding.critica.setImageResource(R.drawable.ic_maxima_critica_sucesso)
                    }
                    "FALHA_PARCIAL" -> {
                        binding.critica.setImageResource(R.drawable.ic_maxima_critica_alerta)
                    }
                    else -> {
                        binding.critica.setImageResource(R.drawable.ic_maxima_aguardando_critica)
                    }
                }
            }
        }
    }

    override fun getFilter(): Filter {
        return customFilter
    }

    private val customFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList = mutableListOf<Pedido>()
            if (constraint == null || constraint.isEmpty()) {
                filteredList.addAll(list)
            } else {
                list.forEach {
                    if (it.nomecliente.lowercase(Locale.getDefault())
                            .contains(constraint.toString().lowercase(Locale.getDefault()))
                    ) {
                        filteredList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, filterResults: FilterResults?) {
            submitList(filterResults?.values as MutableList<Pedido>)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Pedido>() {
    override fun areItemsTheSame(oldItem: Pedido, newItem: Pedido) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Pedido, newItem: Pedido) =
        oldItem.numeroPedErp == newItem.numeroPedErp
}