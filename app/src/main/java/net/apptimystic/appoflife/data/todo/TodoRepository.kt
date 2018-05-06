package net.apptimystic.appoflife.data.todo

public interface TodoRepository {

    fun getTodoItems(): List<Todo>
}