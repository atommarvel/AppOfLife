package net.apptimystic.appoflife.todo

public interface TodoRepository {

    fun getTodoItems(): List<Todo>
}