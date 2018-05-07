package net.apptimystic.appoflife.data.todo

import io.reactivex.Single

interface TodoRepository {

    fun getTodoItems(): Single<List<Todo?>>
}