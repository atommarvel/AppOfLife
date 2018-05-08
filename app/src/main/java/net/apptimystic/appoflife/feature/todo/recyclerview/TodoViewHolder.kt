package net.apptimystic.appoflife.feature.todo.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cell_todo.view.*
import net.apptimystic.appoflife.R

class TodoViewHolder(var itemV: View): RecyclerView.ViewHolder(itemV), RVTodoMVP.TodoView {

    companion object {
        val viewType = 1
        fun inflate(parent: ViewGroup): TodoViewHolder {
            return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_todo, parent, false))
        }
    }

    override fun setDesc(desc: String) {
        itemV.tvDesc.text = desc
    }
}