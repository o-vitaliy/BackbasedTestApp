package ru.ovi.backbased.domain.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

fun <T> LiveData<T>.distinctUntilChanged(): LiveData<T> {
    return Transformations.distinctUntilChanged(this)
}

fun <T> LiveData<T>.postValue(value: T) {
    (this as? MutableLiveData)?.postValue(value) ?: error("$this is not MutableLiveData")
}

fun <T> LiveData<T>.setValue(value: T) {
    (this as? MutableLiveData)?.setValue(value) ?: error("$this is not MutableLiveData")
}
