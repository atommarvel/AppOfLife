package net.apptimystic.appoflife.core

import android.app.Application
import net.apptimystic.appoflife.core.DaggerApplicationComponent
import net.apptimystic.appoflife.feature.todo.TodoModule

class App : Application() {

    var component: ApplicationComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .todoModule(TodoModule())
                .build()
    }
}