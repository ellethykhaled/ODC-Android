package com.lethy._01_cleanarchitecture.data.network

sealed class ApiResponse<out T : Any> {
    data class Success<out T : Any>(val data: T?) : ApiResponse<T>() {
        fun onSuccess(action: (T) -> Unit): ApiResponse<T> {
            data?.let(action)
            return this
        }
    }

    data class Error(val errorMessage: Any) : ApiResponse<Nothing>() {
        fun <T : Any> onError(action: (Any) -> Unit): ApiResponse<T> {
            action(errorMessage)
            return this
        }
    }

    object InProgress : ApiResponse<Nothing>() {
        fun <T : Any> onProgress(action: () -> Unit): ApiResponse<T> {
            action()
            return this
        }
    }
}