package app.mimo.it.bkd.feature.search.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.mimo.it.bkd.databinding.ItemFilterBinding
import app.mimo.it.local.FilterModel

class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val mBinding = ItemFilterBinding.bind(itemView.rootView)

    fun bind(data : FilterModel){
        mBinding.data = data
    }
}