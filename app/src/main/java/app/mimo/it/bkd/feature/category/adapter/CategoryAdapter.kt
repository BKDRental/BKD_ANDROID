package app.mimo.it.bkd.feature.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.mimo.it.bkd.R
import app.mimo.it.bkd.feature.category.viewHolder.CategoryViewHolder
import app.mimo.it.domain.model.CategoryModel
import coil.load

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    private val mItems: MutableList<CategoryModel> = mutableListOf()

    fun setData(data: List<CategoryModel>) {
        mItems.clear()
        mItems.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(mItems[position])
        holder.mBinding.imgCar.load(R.drawable.ic_category_car)
    }

    override fun getItemCount(): Int = mItems.size
}