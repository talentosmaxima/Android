package br.com.maximatech.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.maximatech.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnClientes.setOnClickListener {
            NavigationActivity.launchDadosClienteFragment(this)
        }

        binding.btnPedidos.setOnClickListener {
            NavigationActivity.launchHistoricoPedidosFragment(this)
        }
    }
}