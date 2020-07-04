package ru.ovi.backbased.data.filter

/**
 * Class that filters items from a data provider.
 * Class loads items only once and stores them for further filtering
 */
abstract class DataFilter<T : FilterPropertyProvider>(dataProvider: FilterDataProvider<T>) {

    protected val data: Collection<T> by lazy {
        dataProvider.load()
    }

    /**
     * Method returns collection that filtered by query string
     * If the query is null or empty method returns original item list
     */
    abstract fun filter(query: String?): Collection<T>
}
