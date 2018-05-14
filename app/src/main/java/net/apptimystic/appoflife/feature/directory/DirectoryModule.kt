package net.apptimystic.appoflife.feature.directory

import dagger.Module
import dagger.Provides
import net.apptimystic.appoflife.data.directory.DirectoryParseRepository
import net.apptimystic.appoflife.data.directory.DirectoryRepository
import net.apptimystic.appoflife.feature.directory.recyclerview.DirectoryRVAdapter
import net.apptimystic.appoflife.feature.recyclerview.RVAdapter
import javax.inject.Singleton

@Module
class DirectoryModule {

    @Provides
    fun provideDirectoryRVAdapter(presenter: DirectoryMVP.Presenter): RVAdapter = DirectoryRVAdapter(presenter)

    @Provides
    @Singleton
    fun provideDirectoryPresenter(repo: DirectoryRepository): DirectoryMVP.Presenter = DirectoryPresenter(repo)

    @Provides
    fun provideDirectoryRepository(): DirectoryRepository = DirectoryParseRepository()
}