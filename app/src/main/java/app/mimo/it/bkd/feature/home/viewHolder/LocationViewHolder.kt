package app.mimo.it.bkd.feature.home.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.mimo.it.bkd.databinding.ItemLocationBinding

class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val mBinding = ItemLocationBinding.bind(itemView.rootView)

    fun bind(data: String) {
        mBinding.name = data
    }
}