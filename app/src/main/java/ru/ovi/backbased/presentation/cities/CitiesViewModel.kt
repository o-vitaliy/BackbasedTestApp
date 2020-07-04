package ru.ovi.backbased.presentation.cities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.ovi.backbased.data.entity.CityEntity
import ru.ovi.backbased.domain.cities.CitiesRepository
import ru.ovi.backbased.domain.common.ResourceProvider
import ru.ovi.backbased.domain.common.Result
import ru.ovi.backbased.domain.common.postValue
import ru.ovi.backbased.presentation.common.BaseViewModel

class CitiesViewModel(
    private val citiesRepository: CitiesRepository,
    resourceProvider: ResourceProvider
) : BaseViewModel(resourceProvider) {

    val cities: LiveData<Result<Collection<CityEntity>>> = MutableLiveData()
    val clearIsVisible: LiveData<Boolean> = MutableLiveData(false)

    init {
        launch(cities) {
            citiesRepository.load(null)
        }
    }

    fun filter(query: String?) {
        clearIsVisible.postValue(!query.isNullOrBlank())
        GlobalScope.launch {
            val result = safeExecute {
                citiesRepository.load(query)
            }
            cities.postValue(result)
        }
    }
}
