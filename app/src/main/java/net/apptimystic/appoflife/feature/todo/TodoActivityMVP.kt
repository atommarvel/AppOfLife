package net.apptimystic.appoflife.feature.todo

import io.reactivex.Single
import net.apptimystic.appoflife.data.todo.Todo

interface TodoActivityMVP {

    interface View {
        fun updateData(viewModel: TodoViewModel)
        fun showSnackBar(msg: String)
    }

    interface Presenter {
        var view: TodoActivityMVP.View?

        fun loadData()
        fun rxUnsubscribe()
    }

    interface Model {
        fun result(): Single<TodoViewModel>
    }
}

data class TodoViewModel(var morningTodos: List<Todo> = arrayListOf(), var eveningTodos: List<Todo> = arrayListOf())