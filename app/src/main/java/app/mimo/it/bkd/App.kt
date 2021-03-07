package app.mimo.it.bkd

import android.app.Application
import app.mimo.it.bkd.di.localDataSourceModule
import app.mimo.it.bkd.di.remoteDataModule
import app.mimo.it.bkd.di.useCaseModule
import app.mimo.it.bkd.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                localDataSourceModule,
                remoteDataModule,
                useCaseModule,
                viewModelModules
            )
        }
    }
}