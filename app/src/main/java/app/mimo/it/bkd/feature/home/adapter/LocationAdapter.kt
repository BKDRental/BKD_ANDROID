package app.mimo.it.bkd.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.mimo.it.bkd.R
import app.mimo.it.bkd.feature.home.viewHolder.LocationViewHolder

class LocationAdapter(
    private val callback: (name: String) -> Unit,
    private val openMap: () -> Unit
) : RecyclerView.Adapter<LocationViewHolder>() {

    private val mItems = mutableListOf<String>()

    fun updateData(data: List<String>) {
        mItems.clear()
        mItems.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder =
        LocationViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_location, parent, false)
        )

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(mItems[position])
        holder.mBinding.labelName.setOnClickListener {
            callback.invoke(mItems[position])
        }
        holder.mBinding.containerBkdOffice.setOnClickListener {
            openMap.invoke()
        }
    }

    override fun getItemCount(): Int = mItems.size
}