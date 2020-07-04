package ru.ovi.backbased.data.filter

interface FilterDataProvider<T : FilterPropertyProvider> {
    fun load(): Collection<T>
}