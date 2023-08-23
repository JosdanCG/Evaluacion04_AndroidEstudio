package com.daniel.evaluacion04.model

import java.lang.Exception

sealed class ApisResponse<T>(data: T? = null, exception: java.lang.Exception? =null){
    data class Success<T>(val data:T): ApisResponse<T>(data)
    data class  Error<T>(val exception: Exception): ApisResponse<T>(null, exception)
}
