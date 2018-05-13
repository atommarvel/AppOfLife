package net.apptimystic.appoflife.feature.directory

import dagger.Module
import dagger.Provides
import net.apptimystic.appoflife.data.directory.DirectoryParseRepository
import net.apptimystic.appoflife.data.directory.DirectoryRepository

@Module
class DirectoryModule {

    @Provides
    fun provideDirectoryPresenter(model: DirectoryMVP.Model): DirectoryMVP.Presenter = DirectoryPresenter(model)

    @Provides
    fun provideDirectoryModel(repository: DirectoryRepository): DirectoryMVP.Model = DirectoryModel(repository)

    @Provides
    fun provideDirectoryRepository(): DirectoryRepository = DirectoryParseRepository()
}