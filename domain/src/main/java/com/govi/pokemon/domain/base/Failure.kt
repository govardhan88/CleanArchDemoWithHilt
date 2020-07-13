package com.govi.pokemon.domain.base

sealed class Failure(var retryAction: () -> Unit) : Throwable() {

    class FailureWithMessage(val msg: String?) : Failure({})

}