package ru.ovi.backbased.presentation.cities

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.OrientationHelper
import kotlinx.android.synthetic.main.content_cities.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import ru.ovi.backbased.R
import ru.ovi.backbased.domain.common.Result
import ru.ovi.backbased.presentation.common.BaseContentLoaderFragment
import ru.ovi.backbased.presentation.common.visible
import ru.ovi.backbased.presentation.viewModel

class CitiesFragment : BaseContentLoaderFragment(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val viewModel: CitiesViewModel by viewModel()

    override val contentLayoutId: Int = R.layout.content_cities

    private val adapter = CitiesAdapter {
        findNavController().navigate(
            CitiesFragmentDirections.actionCitiesFragmentToMapFragment(it)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe(viewModel.cities)

        citiesList.adapter = adapter
        citiesList.setHasFixedSize(true)
        citiesList.addItemDecoration(DividerItemDecoration(context, OrientationHelper.VERTICAL))
        viewModel.cities.observe(viewLifecycleOwner, Observer {
            val value = (viewModel.cities.value as? Result.Success)?.data ?: return@Observer
            citiesEmpty.visible = value.isEmpty()
            citiesList.visible = value.isNotEmpty()
            adapter.setItems(value)
        })

        citiesFilter.addTextChangedListener {
            viewModel.filter(it?.toString())
        }

        viewModel.clearIsVisible.observe(
            viewLifecycleOwner,
            Observer { citiesFilterClear.visible = it }
        )
        citiesFilter?.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.filter(v?.text?.toString())
                true
            } else {
                false
            }
        }

        citiesFilterClear.setOnClickListener {
            citiesFilter.text.clear()
        }
    }
}
