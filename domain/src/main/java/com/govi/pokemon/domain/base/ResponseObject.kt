package com.govi.pokemon.domain.base

import androidx.lifecycle.LiveData

data class ResponseObject<T>(val responseObject: LiveData<T>)