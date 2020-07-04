package ru.ovi.backbased.presentation.cities

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.content_cities.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import ru.ovi.backbased.R
import ru.ovi.backbased.domain.common.Result
import ru.ovi.backbased.presentation.common.BaseContentLoaderFragment
import ru.ovi.backbased.presentation.viewModel

class CitiesFragment : BaseContentLoaderFragment(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val viewModel: CitiesViewModel by viewModel()

    override val contentLayoutId: Int = R.layout.content_cities

    private val adapter = CitiesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe(viewModel.cities)

        citiesList.adapter = adapter
        citiesList.setHasFixedSize(true)

        viewModel.cities.observe(viewLifecycleOwner, Observer {
            val value = (viewModel.cities.value as? Result.Success)?.data ?: return@Observer
            adapter.setItems(value)
        })
    }
}
