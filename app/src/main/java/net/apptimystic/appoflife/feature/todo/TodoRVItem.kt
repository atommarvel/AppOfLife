package net.apptimystic.appoflife.feature.todo

import android.support.annotation.NonNull
import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.items.AbstractItem
import com.mikepenz.fastadapter_extensions.swipe.ISwipeable
import kotlinx.android.synthetic.main.cell_todo.view.*
import net.apptimystic.appoflife.R
import net.apptimystic.appoflife.data.todo.Todo


class TodoRVItem(var todo: Todo? = null) : AbstractItem<TodoRVItem, TodoRVItem.ViewHolder>(), ISwipeable<TodoRVItem, TodoRVItem> {

    //The unique ID for this type of item
    override fun getType(): Int = R.id.todo_cell
    //The layout to be used for this type of item
    override fun getLayoutRes(): Int = R.layout.cell_todo
    override fun getViewHolder(@NonNull v: View): ViewHolder = ViewHolder(v)

    // Swipeable
    override fun withIsSwipeable(swipeable: Boolean): TodoRVItem = this
    override fun isSwipeable(): Boolean = true

    class ViewHolder(view: View) : FastAdapter.ViewHolder<TodoRVItem>(view) {

        var desc: String? = null
            set(value) {
                itemView.tvDesc.text = value
            }

        override fun bindView(item: TodoRVItem, payloads: List<Any>) {
            desc = item.todo?.desc
        }

        override fun unbindView(item: TodoRVItem) {
            desc = null
        }
    }
}

fun List<Todo>.wrapForRV(): List<TodoRVItem> {
    return map { TodoRVItem(it) }
}