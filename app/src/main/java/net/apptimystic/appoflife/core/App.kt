package net.apptimystic.appoflife.core

import android.app.Application
import net.apptimystic.appoflife.feature.checklist.ChecklistModule
import net.apptimystic.appoflife.parse.ParseManager


class App : Application() {

    var component: ApplicationComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        setupDagger()
        ParseManager().initParse(this)
    }

    private fun setupDagger() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .checklistModule(ChecklistModule())
                .build()
    }
}