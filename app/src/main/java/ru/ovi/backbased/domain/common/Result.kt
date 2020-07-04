package ru.ovi.backbased.domain.common

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out T : Any> {

    object Loading : Result<Nothing>()
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$message]"
            is Loading -> "Loading"
        }
    }
}

fun <T : Any> Result.Success<T>.isEmpty(): Boolean {
    val isEmptyList = data is Collection<*> && data.isEmpty()
    val isEmptyContent = data is ContentModel && data.isEmpty()
    return isEmptyList || isEmptyContent
}
