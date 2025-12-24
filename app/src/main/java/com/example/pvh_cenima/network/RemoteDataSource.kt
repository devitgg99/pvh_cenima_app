package com.example.pvh_cenima.network

import com.example.pvh_cenima.common.constant.BaseResponse
import com.example.pvh_cenima.common.constant.DataState
import com.example.pvh_cenima.common.constant.ErrorCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException
import java.util.concurrent.CancellationException

abstract class RemoteDataSource<T> {
    protected abstract suspend fun createCall(): Response<BaseResponse<T>>
    fun asFlow(): Flow<DataState<T>> = flow {
        emit(DataState.Loading)
        try {
            val response = createCall()
            if (response.isSuccessful) {
                val body = response.body()?.data
                if (body != null) {
                    emit(DataState.Success(body))
                } else {
                    val errorMessage = response.body()?.message
                        ?: response.message()
                        ?: "Response body is null or empty"
                    emit(
                        DataState.Error(
                            code = response.code(),
                            message = errorMessage
                        )
                    )
                    emit(DataState.MessageSuccess(response.body()?.message ?: "Success"))
                }
            } else {
                response.errorBody()?.string()


//                val errorResponse = try {
//                    Gson().fromJson(errorBodyString, ErrorBaseResponse::class.java)
//                } catch (e: Exception) {
//                    null
//                }
//
//                val message = errorResponse?.errors?.errorMessage
//                    ?: errorBodyString?.takeIf { it.isNotBlank() }
//                    ?: response.message()
//                    ?: "Unknown error"
//                val code = errorResponse?.errors?.code ?: response.code()


//                emit(DataState.Error(code, message))
            }
        } catch (e: Exception) {
            when (e) {
                is CancellationException ->
                    return@flow

                is UnknownHostException, is ConnectException, is SocketException ->
                    emit(DataState.Error(ErrorCode.CONNECTION_ERROR, "No internet connection"))

                else ->
                    emit(
                        DataState.Error(
                            ErrorCode.UNKNOWN_ERROR,
                            message = e.message ?: "Unexpected error",
                        )
                    )
            }
        }
    }
}