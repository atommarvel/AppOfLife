package net.apptimystic.appoflife.feature.checklist.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import net.apptimystic.appoflife.feature.checklist.ChecklistMVP
import net.apptimystic.appoflife.feature.recyclerview.RVAdapter
import javax.inject.Inject

class ChecklistRVAdapter @Inject constructor(presenter: ChecklistMVP.Presenter) : RVAdapter(presenter) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TaskViewHolder.inflate(parent)
    }
}