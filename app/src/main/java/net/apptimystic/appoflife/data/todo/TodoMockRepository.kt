package net.apptimystic.appoflife.data.todo

import io.reactivex.Observable
import io.reactivex.Single

class TodoMockRepository: TodoRepository {

    override fun getTodoItems(): Single<List<Todo>> {
        return Observable.range(1, 5)
                .map({ Todo("item number $it") })
                .toList()
    }
}