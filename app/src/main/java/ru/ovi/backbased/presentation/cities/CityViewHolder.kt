package ru.ovi.backbased.presentation.cities

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_city.view.*
import ru.ovi.backbased.R
import ru.ovi.backbased.data.entity.CityEntity

class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(value: CityEntity) {
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

            setOnClickListener {
                /*  val bundle = bundleOf("ref" to value)
                    findNavController().navigate(
                    R.id.action_transactions_to_detialsTransactionFragment,
                    bundle
                )*/
            }
        }
    }

    companion object {
        const val LAYOUT_ID = R.layout.item_city
        private const val DATE_FORMAT = "yyyy-MM-dd HH:mm"
    }
}
