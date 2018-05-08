package net.apptimystic.appoflife.feature.todo.recyclerview

import net.apptimystic.appoflife.feature.recyclerview.RVPresenter

interface RVTodoMVP {
    interface TodoView {
        fun setDesc(desc: String)
    }

    interface HeaderView {
        fun setLabel(label: String)
    }

    interface Presenter: RVPresenter
}