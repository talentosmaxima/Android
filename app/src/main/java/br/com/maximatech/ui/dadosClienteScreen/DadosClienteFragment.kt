package br.com.maximatech.ui.dadosClienteScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.maximatech.R
import br.com.maximatech.core.extensions.showSnackbar
import br.com.maximatech.data.model.Cliente
import br.com.maximatech.databinding.FragmentDadosClienteBinding
import br.com.maximatech.ui.State
import br.com.maximatech.ui.ViewManagerState

class DadosClienteFragment : Fragment() {

    private lateinit var binding: FragmentDadosClienteBinding
    private lateinit var adapter: DadosClienteAdapter
    private lateinit var viewModel: DadosClienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDadosClienteBinding.inflate(inflater, container, false)
        val root = binding.root
        val stateAction = ViewManagerState(
            binding.clHistoricoPedidosScreen, binding.btnTentarNovamente, binding.loading
        )
        viewModel = ViewModelProvider(this).get(DadosClienteViewModel::class.java)
        adapter = DadosClienteAdapter()


        binding.rvContatosCliente.layoutManager = LinearLayoutManager(root.context)
        binding.rvContatosCliente.adapter = adapter

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.label_dados_do_cliente)
        val viewManagerState = ViewManagerState(
            binding.clHistoricoPedidosScreen, binding.btnTentarNovamente, binding.loading
        )

        viewModel.fetchData()

        binding.btnVerificarStatus.setOnClickListener {
            binding.root.showSnackbar(
                viewModel.getClientDataStatus()
            )
        }

        binding.btnTentarNovamente.setOnClickListener {
            viewModel.fetchData()
        }

        viewModel.client.observe(viewLifecycleOwner) { setupUIFields(it) }

        viewModel.apiRequestState.observe(viewLifecycleOwner) {
            when (it) {
                State.SUCCESS -> {
                    viewManagerState.success()
                }
                State.LOADING -> {
                    viewManagerState.loading()
                }
                State.ERROR -> {
                    viewManagerState.error()
                    view.showSnackbar(
                        message = getString(R.string.dados_cliente_error_loading),
                    )
                }
            }
        }

    }

    private fun setupUIFields(cliente: Cliente) {
        binding.codigoERazaoSocial.text = getString(
            R.string.label_codigo_razao_social,
            cliente.codigo, cliente.razaoSocial
        )
        binding.nomeFantasia.text = cliente.nomeFantasia
        binding.cnpj.text = cliente.cnpj
        binding.ramoAtividade.text = cliente.ramoAtividade
        binding.enderecos.text = cliente.endereco
        adapter.submitList(cliente.contatos)
    }
}
