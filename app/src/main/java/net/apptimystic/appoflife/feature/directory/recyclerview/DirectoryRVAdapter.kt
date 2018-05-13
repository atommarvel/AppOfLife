package net.apptimystic.appoflife.feature.directory.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import net.apptimystic.appoflife.feature.recyclerview.RVPresenter
import java.lang.IllegalStateException

class DirectoryRVAdapter(private val presenter: RVPresenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ChecklistViewHolder.viewType -> ChecklistViewHolder.inflate(parent, presenter)
            else -> throw IllegalStateException("viewType $viewType is not covered")
        }
    }

    override fun getItemCount(): Int = presenter.getItemCount()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        presenter.bindViewHolder(holder, position)
    }

    override fun getItemViewType(position: Int): Int = presenter.getItemType(position)
}