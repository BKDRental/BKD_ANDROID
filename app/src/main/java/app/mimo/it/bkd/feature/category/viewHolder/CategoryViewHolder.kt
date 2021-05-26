package app.mimo.it.bkd.feature.category.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.mimo.it.bkd.databinding.ItemCategoryBinding
import app.mimo.it.domain.model.CategoryModel

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val mBinding = ItemCategoryBinding.bind(itemView.rootView)

    fun bind(categoryModel: CategoryModel) {
        mBinding.model = categoryModel
    }
}