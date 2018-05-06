package net.apptimystic.appoflife.feature.todo

import io.reactivex.Observable
import net.apptimystic.appoflife.data.todo.TodoRepository

class TodoModel(var repository: TodoRepository) : TodoActivityMVP.Model {

    override fun result(): Observable<TodoViewModel> {
        return Observable.just(repository.getTodoItems())
                .map { TodoViewModel(it) }
    }
}