package ru.ovi.backbased.data.filter

abstract class DataFilter<T : FilterPropertyProvider>(contentDataSource: FilterDataProvider<T>) {

    protected val data: Collection<T> by lazy {
        contentDataSource.load()
    }

    abstract fun filter(query: String?): Collection<T>
}
