package br.com.maximatech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.maximatech.databinding.ActivityCustomSplashScreenBinding

class CustomSplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomSplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomSplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(
            this@CustomSplashScreenActivity,
            MainActivity::class.java
        )

        if(android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.R){
            startActivity(intent)
        } else {
            binding.maximaTechIcon.alpha = 0f
            binding.maximaTechIcon.animate().setDuration(2000).alpha(1f).withEndAction {
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }
    }
}