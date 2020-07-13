package com.govi.pokemon.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.govi.pokemon.data.base.ResponseResult
import com.govi.pokemon.data.base.ResponseWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber
import java.net.ConnectException

open class BaseRemoteDataSource {

    protected suspend fun <T> getResult(
        call: suspend () -> Response<T>
    ): ResponseResult<ResponseWrapper<T>> = try {
        kotlin.run {
            val response = call()
            return when {
                response.isSuccessful -> {
                    val body = response.body()
                    ResponseResult.Success(ResponseWrapper(body, null))
                }
                else -> {
                    error("${response.code()} ${response.message()}")
                }
            }
        }
    } catch (e: Exception) {
        Timber.e(e.localizedMessage)
        error(e)
    }

    private fun <T> error(e: Exception): ResponseResult<ResponseWrapper<T>> =
        when (e) {
            is ConnectException ->
                ResponseResult.Error(ResponseWrapper(null, "Connection Error"))
            else ->
                ResponseResult.Error(
                    ResponseWrapper(
                        null,
                        "Something went wrong. Please try again."
                    )
                )
        }

    // produce LiveData
    fun <T> resultLiveData(
        scope: CoroutineScope,
        call: suspend () -> ResponseResult<T>
    ): LiveData<ResponseResult<T>> {
        return liveData(scope.coroutineContext) {
            emit(ResponseResult.Loading)

            withContext(Dispatchers.IO) {
                emit(call.invoke())
            }
        }
    }

}