package app.mimo.it.bkd.feature.home.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.mimo.it.bkd.databinding.ItemTimeBinding

class TimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mBinding = ItemTimeBinding.bind(itemView.rootView)

    fun bind(time: String) {
        mBinding.time = time
    }
}