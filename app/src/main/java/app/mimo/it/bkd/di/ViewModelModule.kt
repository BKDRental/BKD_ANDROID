package app.mimo.it.bkd.di

import app.mimo.it.bkd.viewModel.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { SplashViewModel() }
    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { CategoryViewModel() }
    viewModel { NotificationViewModel() }
    viewModel { ProfileViewModel() }
}