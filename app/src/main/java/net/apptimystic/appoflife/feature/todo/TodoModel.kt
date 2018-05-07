package net.apptimystic.appoflife.feature.todo

import io.reactivex.Single
import net.apptimystic.appoflife.data.todo.TodoRepository

class TodoModel(var repository: TodoRepository) : TodoActivityMVP.Model {

    override fun result(): Single<TodoViewModel> {
        return repository.getTodoItems()
                .map { TodoViewModel(it) }
    }
}