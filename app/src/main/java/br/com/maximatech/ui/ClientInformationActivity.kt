package br.com.maximatech.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.maximatech.R
import br.com.maximatech.databinding.ActivityClientInformationBinding

class ClientInformationActivity : AppCompatActivity() {

    private val binding by lazy { ActivityClientInformationBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object{
        fun launchClientInformationScreen(context: Context){
            val intent = Intent(context, ClientInformationActivity::class.java)
            context.startActivity(intent)
        }
    }
}