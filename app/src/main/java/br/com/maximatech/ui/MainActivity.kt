package br.com.maximatech.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.maximatech.databinding.ActivityMainBinding
import br.com.maximatech.ui.clientInformationScreen.ClientInformationActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnClients.setOnClickListener {
            ClientInformationActivity.launchClientInformationScreen(this)
        }
    }
}