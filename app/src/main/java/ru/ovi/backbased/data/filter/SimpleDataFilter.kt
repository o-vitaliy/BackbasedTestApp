package ru.ovi.backbased.data.filter

class SimpleDataFilter<T : FilterPropertyProvider>(
    provider: FilterDataProvider<T>
) : DataFilter<T>(provider) {

    override fun filter(query: String?): Collection<T> {
        return if (query == null) {
            data
        } else {
            data.filter { it.filterProperty().startsWith(query, true) }
        }
    }
}
