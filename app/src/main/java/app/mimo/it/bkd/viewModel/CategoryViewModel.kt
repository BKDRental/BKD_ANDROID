package app.mimo.it.bkd.viewModel

import app.mimo.it.bkd.R
import app.mimo.it.core.base.BaseViewModel
import app.mimo.it.domain.model.CategoryModel

class CategoryViewModel : BaseViewModel() {

    fun getData() = mutableListOf(
        CategoryModel(
            name = "Vans",
            image = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        ),
        CategoryModel(
            name = "Vans",
            image = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        ),
        CategoryModel(
            name = "Vans",
            image = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        ),
        CategoryModel(
            name = "Vans",
            image = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        ),
        CategoryModel(
            name = "Vans",
            image = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        )
    )
}