package net.apptimystic.appoflife.feature.todo.recyclerview

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import net.apptimystic.appoflife.feature.recyclerview.ITHPresenter

class SwipeTouchHelper(val presenter: ITHPresenter) : ItemTouchHelper.Callback() {

    override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int {
        return presenter.movementFlags(viewHolder?.itemViewType)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        presenter.itemSwiped(viewHolder?.adapterPosition)
    }

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean = false
}