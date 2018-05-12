package net.apptimystic.appoflife.feature.checklist.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import net.apptimystic.appoflife.feature.recyclerview.RVPresenter
import java.lang.IllegalStateException


class ChecklistRVAdapter(private val presenter: RVPresenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        presenter.bindViewHolder(holder, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            TaskViewHolder.viewType -> TaskViewHolder.inflate(parent)
            else -> throw IllegalStateException("viewType $viewType is not covered")
        }
    }

    override fun getItemCount(): Int = presenter.getItemCount()

    override fun getItemViewType(position: Int): Int {
        return presenter.getItemType(position)
    }
}