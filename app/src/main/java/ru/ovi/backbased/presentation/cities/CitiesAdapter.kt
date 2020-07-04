package ru.ovi.backbased.presentation.cities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ovi.backbased.data.entity.CityEntity

class CitiesAdapter(
    private val onClick: (CityEntity) -> Unit
) : RecyclerView.Adapter<CityViewHolder>() {

    private val items = ArrayList<CityEntity>()

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

    fun setItems(items: Collection<CityEntity>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }
}
