package com.example.warzywniak

sealed class ApiResponse<out T> {
    class Loading<T>: ApiResponse<T>()
    class Success<T>(val value: T): ApiResponse<T>()
    class Error<T>(val message: String): ApiResponse<T>()
}
