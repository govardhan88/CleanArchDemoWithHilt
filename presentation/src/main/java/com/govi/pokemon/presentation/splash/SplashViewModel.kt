package com.govi.pokemon.presentation.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.govi.pokemon.presentation.base.viewmodel.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class SplashViewModel @ViewModelInject constructor() : BaseViewModel() {

    private val mLDFinshScreen: MutableLiveData<Boolean> = MutableLiveData()
    val lDFinshScreen: LiveData<Boolean> = mLDFinshScreen

    fun start() {
        viewModelScope.launch {
            delay(1500)
            mLDFinshScreen.value = true
        }
    }

}