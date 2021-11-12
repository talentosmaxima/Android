package br.com.maximatech.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.maximatech.BuildConfig
import br.com.maximatech.R
import br.com.maximatech.core.extensions.showSnackbar
import br.com.maximatech.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.appVersion.text = getString(
            R.string.label_app_version,
            BuildConfig.VERSION_NAME
        )

        binding.btnClientes.setOnClickListener {
            NavigationActivity.launchDadosClienteFragment(this)
        }

        binding.btnPedidos.setOnClickListener {
            NavigationActivity.launchHistoricoPedidosFragment(this)
        }

        binding.btnResumosDeVendas.setOnClickListener {
            it.showSnackbar(getString(R.string.label_funcionalidade_ainda_nao_disponivel))
        }

        binding.btnFerramentas.setOnClickListener {
            it.showSnackbar(getString(R.string.label_funcionalidade_ainda_nao_disponivel))
        }
    }
}