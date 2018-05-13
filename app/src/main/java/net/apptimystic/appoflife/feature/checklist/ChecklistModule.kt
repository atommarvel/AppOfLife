package net.apptimystic.appoflife.feature.checklist

import dagger.Module
import dagger.Provides
import net.apptimystic.appoflife.data.checklist.ChecklistParseRepository
import net.apptimystic.appoflife.data.checklist.ChecklistRepository

@Module
class ChecklistModule {

    @Provides
    fun provideChecklistPresenter(model: ChecklistMVP.Model): ChecklistMVP.Presenter = ChecklistPresenter(model)

    @Provides
    fun provideChecklistModel(repository: ChecklistRepository): ChecklistMVP.Model = ChecklistModel(repository)

    @Provides
    fun provideChecklistRepository(): ChecklistRepository = ChecklistParseRepository()
}