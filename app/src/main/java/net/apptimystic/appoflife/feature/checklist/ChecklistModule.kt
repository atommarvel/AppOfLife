package net.apptimystic.appoflife.feature.checklist

import dagger.Module
import dagger.Provides
import net.apptimystic.appoflife.data.checklist.ChecklistParseRepository
import net.apptimystic.appoflife.data.checklist.ChecklistRepository
import net.apptimystic.appoflife.feature.checklist.recyclerview.ChecklistRVAdapter
import net.apptimystic.appoflife.feature.recyclerview.RVAdapter
import javax.inject.Singleton

@Module
class ChecklistModule {

    @Provides
    fun provideChecklistRVAdapter(presenter: ChecklistMVP.Presenter): RVAdapter = ChecklistRVAdapter(presenter)

    @Provides
    @Singleton
    fun provideChecklistPresenter(repo: ChecklistRepository): ChecklistMVP.Presenter = ChecklistPresenter(repo)

    @Provides
    fun provideChecklistRepository(): ChecklistRepository = ChecklistParseRepository()
}