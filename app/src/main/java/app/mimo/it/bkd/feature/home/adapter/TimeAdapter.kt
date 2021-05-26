package app.mimo.it.bkd.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.mimo.it.bkd.R
import app.mimo.it.bkd.feature.home.viewHolder.TimeViewHolder

class TimeAdapter(private val callBack: (time: String) -> Unit) :
    RecyclerView.Adapter<TimeViewHolder>() {

    private val mItems = mutableListOf<String>()

    fun updateData(data: List<String>) {
        mItems.clear()
        mItems.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeViewHolder =
        TimeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_time, parent, false)
        )

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
        holder.bind(mItems[position])
        holder.itemView.setOnClickListener { callBack.invoke(mItems[position]) }
    }

    override fun getItemCount(): Int = mItems.size
}