package com.govi.pokemon.presentation.base.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.viewbinding.ViewBinding
import com.govi.pokemon.presentation.extensions.viewBinding

abstract class BaseActivity<VM : ViewModel, VB : ViewBinding>(
    inflate: (LayoutInflater) -> VB,
    viewModelClass: Class<VM>
) : AppCompatActivity() {

    protected abstract val navControllerId: Int?
    protected val binding: VB by viewBinding(inflate)
    protected val viewModel: VM by lazy { ViewModelProvider(this).get(viewModelClass) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
    }

    private val navController: NavController by lazy {
        findNavController(this, navControllerId ?: 0)
    }

    override fun onNavigateUp(): Boolean = navController.navigateUp()

    protected fun startActivity(
        activityClass: Class<out AppCompatActivity>,
        finishCurrent: Boolean = false
    ) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        if (finishCurrent) finish()
    }

}