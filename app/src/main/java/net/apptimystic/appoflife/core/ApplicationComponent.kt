package net.apptimystic.appoflife.core

import dagger.Component
import net.apptimystic.appoflife.LaunchActivity
import net.apptimystic.appoflife.feature.todo.TodoActivityView
import net.apptimystic.appoflife.feature.todo.TodoModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, TodoModule::class])
interface ApplicationComponent {

    fun inject(target: LaunchActivity)
    fun inject(target: TodoActivityView)
}
