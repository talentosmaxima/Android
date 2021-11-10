package br.com.maximatech.ui.clientInformationScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.maximatech.data.model.Contato
import br.com.maximatech.databinding.ContatosClienteItemBinding

class ClientInformationAdapter :
    ListAdapter<Contato, ClientInformationAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContatosClienteItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ContatosClienteItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Contato) {
            binding.apply {
                nome.text = item.nome
                telefone.text = item.telefone
                email.text = item.email
                celular.text = item.celular
                dataNasc.text = item.dataNascimento
                conjuge.text = item.conjuge
                dataNascConjuge.text = item.dataNascimentoConjuge
                tipo.text = item.tipo
                time.text = item.time
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Contato>() {
        override fun areContentsTheSame(oldItem: Contato, newItem: Contato) =
            oldItem.nome == newItem.nome

        override fun areItemsTheSame(oldItem: Contato, newItem: Contato) = oldItem == newItem
    }
}