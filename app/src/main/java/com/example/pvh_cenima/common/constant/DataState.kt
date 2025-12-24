package com.example.pvh_cenima.common.constant

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val code: Int? = null, val message: String? = null) : DataState<Nothing>()

    //Use for empty body or payload
    data class MessageSuccess(val message: String) : DataState<Nothing>()
    data object Loading : DataState<Nothing>()
}