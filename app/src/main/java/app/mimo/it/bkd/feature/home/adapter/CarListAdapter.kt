package app.mimo.it.bkd.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.mimo.it.bkd.R
import app.mimo.it.bkd.feature.home.viewHolder.CarListViewHolder

class CarListAdapter : RecyclerView.Adapter<CarListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder =
        CarListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_car_list, parent, false)
        )

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 10
}