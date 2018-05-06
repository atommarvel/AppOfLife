package net.apptimystic.appoflife.todo

import android.support.annotation.NonNull
import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.cell_todo.view.*
import net.apptimystic.appoflife.R


class TodoItem : AbstractItem<TodoItem, TodoItem.ViewHolder>() {
    var todo: Todo? = null

    //The unique ID for this type of item
    override fun getType(): Int = R.id.todo_item
    //The layout to be used for this type of item
    override fun getLayoutRes(): Int = R.layout.cell_todo
    override fun getViewHolder(@NonNull v: View): ViewHolder = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<TodoItem>(view) {

        var desc: String? = null
            set(value) {
                itemView.tvDesc.text = value
            }

        override fun bindView(item: TodoItem, payloads: List<Any>) {
            desc = item.todo?.desc
        }

        override fun unbindView(item: TodoItem) {
            desc = null
        }
    }
}