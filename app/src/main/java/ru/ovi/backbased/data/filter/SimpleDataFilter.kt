package ru.ovi.backbased.data.filter

/**
 * @see DataFilter
 *
 * Simple implementation of filtering data.
 * Every item is checked whether it starts with a query string.
 */
class SimpleDataFilter<T : FilterPropertyProvider>(
    provider: FilterDataProvider<T>
) : DataFilter<T>(provider) {

    override fun filter(query: String?): Collection<T> {
        return if (query == null || query.isEmpty()) {
            data
        } else {
            data.filter { it.filterProperty().startsWith(query, true) }
        }
    }
}
