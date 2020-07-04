package ru.ovi.backbased.presentation.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ovi.backbased.R
import ru.ovi.backbased.domain.common.ResourceProvider
import ru.ovi.backbased.domain.common.Result
import ru.ovi.backbased.domain.common.postValue

@SuppressWarnings("TooGenericExceptionCaught")
abstract class BaseViewModel(val resourceProvider: ResourceProvider) : ViewModel() {

    inline fun <T : Any> launch(
        liveData: LiveData<Result<T>>,
        updateLoading: Boolean = true,
        crossinline block: suspend () -> T
    ) {
        GlobalScope.launch {
            if (updateLoading) liveData.postValue(Result.Loading)
            liveData.postValue(safeExecute(block))
        }
    }

    suspend inline fun <T : Any> safeExecute(
        crossinline block: suspend () -> T
    ): Result<T> {
        return try {
            val r: T = withContext(Dispatchers.IO) { block() }
            Result.Success(r)
        } catch (ex: Exception) {
            Result.Error(resourceProvider.getString(R.string.error_something_wrong))
        }
    }
}
