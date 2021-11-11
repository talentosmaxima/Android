package br.com.maximatech.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.maximatech.R
import br.com.maximatech.databinding.ActivityNavigationBinding
import br.com.maximatech.ui.alvarasScreen.AlvarasFragment
import br.com.maximatech.ui.dadosClienteScreen.DadosClienteFragment
import br.com.maximatech.ui.historicoPedidosScreen.HistoricoPedidosFragment

class NavigationActivity : AppCompatActivity() {

    private val binding by lazy { ActivityNavigationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, selectedFragment!!).commit()

        binding.bottomNavView.selectedItemId = bottomNavIconSelected!!

        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_nav_icon_dados_cliente -> {
                    selectedFragment = DadosClienteFragment()
                }
                R.id.bottom_nav_icon_historico_pedidos -> {
                    selectedFragment = HistoricoPedidosFragment()
                }
                R.id.bottom_nav_icon_alvaras -> {
                    selectedFragment = AlvarasFragment()
                }
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                selectedFragment!!
            ).commit()
            true
        }

    }

    companion object {
        private var selectedFragment: Fragment? = null
        private var bottomNavIconSelected: Int? = null

        fun launchDadosClienteFragment(context: Context) {
            val intent = Intent(context, NavigationActivity::class.java)
            context.startActivity(intent)
            bottomNavIconSelected = R.id.bottom_nav_icon_dados_cliente
            selectedFragment = DadosClienteFragment()
        }

        fun launchHistoricoPedidosFragment(context: Context) {
            val intent = Intent(context, NavigationActivity::class.java)
            context.startActivity(intent)
            bottomNavIconSelected = R.id.bottom_nav_icon_historico_pedidos
            selectedFragment = HistoricoPedidosFragment()
        }
    }
}