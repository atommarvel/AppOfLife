package net.apptimystic.appoflife.data.todo

import io.reactivex.Observable

interface TodoRepository {

    fun getTodoItems(): Observable<Todo>
}