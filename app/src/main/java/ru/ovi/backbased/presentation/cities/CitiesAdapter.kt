package ru.ovi.backbased.presentation.cities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CitiesAdapter(
    private val onClick: (ru.ovi.backbased.data.entity.CityEntity) -> Unit
) : RecyclerView.Adapter<CityViewHolder>() {

    private val items = ArrayList<ru.ovi.backbased.data.entity.CityEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(
            LayoutInflater.from(parent.context).inflate(CityViewHolder.LAYOUT_ID, parent, false),
            onClick
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: Collection<ru.ovi.backbased.data.entity.CityEntity>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }
}
