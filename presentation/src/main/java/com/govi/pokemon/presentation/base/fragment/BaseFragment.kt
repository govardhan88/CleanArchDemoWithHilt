package com.govi.pokemon.presentation.base.fragment

import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.govi.pokemon.presentation.base.viewmodel.BaseViewModel
import com.govi.pokemon.presentation.extensions.viewBinding

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes val layoutRes: Int,
    bind: (View) -> VB,
    viewModelClass: Class<VM>
) : Fragment(layoutRes) {

    protected val binding: VB by viewBinding(bind)
    protected val viewModel: VM  by lazy { ViewModelProvider(this).get(viewModelClass) }

}