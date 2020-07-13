package com.govi.pokemon.presentation.splash

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.govi.pokemon.presentation.base.activity.BaseActivity
import com.govi.pokemon.presentation.databinding.SplashActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity(override val navControllerId: Int? = null) :
    BaseActivity<SplashViewModel, SplashActivityBinding>(
        SplashActivityBinding::inflate,
        SplashViewModel::class.java
    ) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.lDFinshScreen.observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.start()
    }

}