package com.example.musicalbumsapp.util


//View states
sealed class Result<T> (val data: List<T>?, val message: String?) {
    class Success<T> (data: List<T>, message: String? = null) : Result<T> (data, message)
    class Error<T> (data: List<T>? = null, message: String) : Result<T>(data, message)
    class Loading<T> (): Result<T> (null, null)
}