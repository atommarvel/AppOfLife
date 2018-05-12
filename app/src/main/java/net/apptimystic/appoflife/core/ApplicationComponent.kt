package net.apptimystic.appoflife.core

import dagger.Component
import net.apptimystic.appoflife.LaunchActivity
import net.apptimystic.appoflife.feature.checklist.ChecklistView
import net.apptimystic.appoflife.feature.checklist.ChecklistModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ChecklistModule::class])
interface ApplicationComponent {

    fun inject(target: LaunchActivity)
    fun inject(target: ChecklistView)
}
