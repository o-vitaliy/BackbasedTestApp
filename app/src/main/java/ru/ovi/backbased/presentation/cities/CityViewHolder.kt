package ru.ovi.backbased.presentation.cities

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_city.view.*
import ru.ovi.backbased.R

class CityViewHolder(
    view: View,
    private val onClick: (ru.ovi.backbased.data.entity.CityEntity) -> Unit
) : RecyclerView.ViewHolder(view) {

    fun bind(value: ru.ovi.backbased.data.entity.CityEntity) {
        with(itemView) {
            itemCityTitle.text = resources.getString(
                R.string.city_title_format,
                value.name,
                value.country
            )

            itemCitySubtite.text = resources.getString(
                R.string.city_subtitle_format,
                value.coordinates.latitude,
                value.coordinates.longitude
            )

            setOnClickListener { onClick(value) }
        }
    }

    companion object {
         val LAYOUT_ID = R.layout.item_city
    }
}
