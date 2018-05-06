package net.apptimystic.appoflife

import android.app.Application

class App : Application() {

    var component: ApplicationComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}