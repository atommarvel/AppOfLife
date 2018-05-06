package net.apptimystic.appoflife.data.todo

import io.reactivex.Observable

class MockRepository: TodoRepository {

    override fun getTodoItems(): List<Todo> {
        return Observable.range(1, 5)
                .map({ Todo("item number $it") })
                .toList()
                .blockingGet()
    }
}