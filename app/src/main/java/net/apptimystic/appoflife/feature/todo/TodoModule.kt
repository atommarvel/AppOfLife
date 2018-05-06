package net.apptimystic.appoflife.feature.todo

import dagger.Module
import dagger.Provides
import net.apptimystic.appoflife.data.todo.MockRepository
import net.apptimystic.appoflife.data.todo.TodoRepository

@Module
class TodoModule {

    @Provides
    fun provideTodoPresenter(model: TodoActivityMVP.Model): TodoActivityMVP.Presenter = TodoPresenter(model)

    @Provides
    fun provideTodoModel(repository: TodoRepository): TodoActivityMVP.Model = TodoModel(repository)

    @Provides
    fun provideTodoRepository(): TodoRepository = MockRepository()
}