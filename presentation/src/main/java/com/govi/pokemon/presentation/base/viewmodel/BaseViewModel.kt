package com.govi.pokemon.presentation.base.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var application: Application
    private val mutableFailure: MutableLiveData<Any> = MutableLiveData()
    val ldFailure: LiveData<Any> = mutableFailure
    private val mutableLoading: MutableLiveData<Boolean> = MutableLiveData()
    val ldLoading: LiveData<Boolean> = mutableLoading

    private fun getFailure(throwable: Throwable) = throwable as? Any

    protected fun handleFailure(throwable: Throwable) {
        mutableFailure.value = getFailure(throwable)
    }

    fun loading(visible: Boolean) {
        mutableLoading.value = visible
    }

}