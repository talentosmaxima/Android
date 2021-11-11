package br.com.maximatech.ui.dadosClienteScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.maximatech.core.extensions.checkIsNullOrBlank
import br.com.maximatech.data.model.Contato
import br.com.maximatech.databinding.ItemContatosClienteBinding

class DadosClienteAdapter :
    ListAdapter<Contato, DadosClienteAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContatosClienteBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemContatosClienteBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Contato) {
            binding.apply {
                nome.text = item.nome.checkIsNullOrBlank()
                telefone.text = item.telefone.checkIsNullOrBlank()
                email.text = item.email.checkIsNullOrBlank()
                celular.text = item.celular.checkIsNullOrBlank()
                dataNasc.text = item.dataNascimento.checkIsNullOrBlank()
                conjuge.text = item.conjuge.checkIsNullOrBlank()
                dataNascConjuge.text = item.dataNascimentoConjuge.checkIsNullOrBlank()
                tipo.text = item.tipo.checkIsNullOrBlank()
                time.text = item.time.checkIsNullOrBlank()
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Contato>() {
        override fun areContentsTheSame(oldItem: Contato, newItem: Contato) =
            oldItem.nome == newItem.nome

        override fun areItemsTheSame(oldItem: Contato, newItem: Contato) = oldItem == newItem
    }
}