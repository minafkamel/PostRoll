package com.minafkamel.postroll.util

sealed class UiState<out T> {
    data class Success<out T>(val data: T) : UiState<T>()
    object Loading : UiState<Nothing>()
    object Error : UiState<Nothing>()
}