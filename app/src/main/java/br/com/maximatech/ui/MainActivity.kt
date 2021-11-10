package br.com.maximatech.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.maximatech.R
import br.com.maximatech.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnClients.setOnClickListener{
            ClientInformationActivity.launchClientInformationScreen(this)
        }
    }
}