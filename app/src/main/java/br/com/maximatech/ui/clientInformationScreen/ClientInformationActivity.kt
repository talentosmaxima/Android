package br.com.maximatech.ui.clientInformationScreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.maximatech.R
import br.com.maximatech.core.extensions.getCurrentTime
import br.com.maximatech.core.extensions.showSnackbar
import br.com.maximatech.data.model.Cliente
import br.com.maximatech.databinding.ActivityClientInformationBinding

class ClientInformationActivity : AppCompatActivity() {

    private val binding by lazy { ActivityClientInformationBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ClientInformationViewModel(application) }
    private val adapter by lazy { ClientInformationAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        binding.rvContatosCliente.layoutManager = LinearLayoutManager(this)
        binding.rvContatosCliente.adapter = adapter

        var fieldMessage = ""
        var client: Cliente? = null
        client?.let { setupUIFields(it) }
        viewModel.getData()

        binding.btnVerificarStatus.setOnClickListener {
            if (client == viewModel.client.value) {
                it.showSnackbar(
                    message = "${getCurrentTime()} - ${client!!.status}",
                    anchorView = binding.bottomNavView
                )
            } else {
                viewModel.getData()
            }
        }

        viewModel.client.observe(this)
        {
            client = it
        }


        viewModel.apiRequestState.observe(this)
        {
            when (it) {
                ClientInformationViewModel.State.SUCCESS -> {
                    client = viewModel.client.value
                    client?.let { cliente -> setupUIFields(cliente) }
                }
                ClientInformationViewModel.State.LOADING -> {
                    fieldMessage = this.getString(R.string.loading)
                    client = viewModel.sampleClient(fieldMessage)
                    setupUIFields(client!!)
                }

                ClientInformationViewModel.State.ERROR -> {
                    view.showSnackbar(
                        message = getString(R.string.error),
                        anchorView = binding.bottomNavView
                    )
                    fieldMessage = this.getString(R.string.error)
                    client = viewModel.sampleClient(fieldMessage)
                    setupUIFields(client!!)
                }

            }
        }
    }

    private fun setupUIFields(client: Cliente) {
        binding.codigo.text = "${client.codigo} - "
        binding.razaoSocial.text = client.razaoSocial
        binding.nomeFantasia.text = client.nomeFantasia
        binding.cnpj.text = client.cnpj
        binding.ramoAtividade.text = client.ramoAtividade
        binding.enderecos.text = client.endereco
        adapter.submitList(client.contatos)
    }

    companion object {
        fun launchClientInformationScreen(context: Context) {
            val intent = Intent(context, ClientInformationActivity::class.java)
            context.startActivity(intent)
        }
    }
}