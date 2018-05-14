package net.apptimystic.appoflife.feature.directory.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import net.apptimystic.appoflife.feature.directory.DirectoryMVP
import net.apptimystic.appoflife.feature.recyclerview.RVAdapter
import javax.inject.Inject

class DirectoryRVAdapter @Inject constructor(presenter: DirectoryMVP.Presenter) : RVAdapter(presenter) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ChecklistViewHolder.inflate(parent, presenter)
    }
}