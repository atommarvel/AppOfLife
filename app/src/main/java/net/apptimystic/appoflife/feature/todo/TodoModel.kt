package net.apptimystic.appoflife.feature.todo

import io.reactivex.Observable
import io.reactivex.Single
import net.apptimystic.appoflife.data.todo.Todo
import net.apptimystic.appoflife.data.todo.TodoRepository

class TodoModel(var repository: TodoRepository) : TodoActivityMVP.Model {

    // TODO: learn more rx to best split and rejoin as two lists. Groupby?
    override fun result(): Single<TodoViewModel> {
        val todosObs = repository.getTodoItems()
        val morningTodos = filterGroup("morning", todosObs)
        val eveningTodos = filterGroup("evening", todosObs)
        return Single.just(TodoViewModel(morningTodos, eveningTodos))
    }

    private fun filterGroup(group: String, todosObs: Observable<Todo>): List<Todo> {
        return todosObs.filter { it.group == group }
                .toList()
                .blockingGet()
    }
}