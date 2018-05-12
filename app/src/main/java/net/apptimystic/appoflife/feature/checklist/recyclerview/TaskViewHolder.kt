package net.apptimystic.appoflife.feature.checklist.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cell_task.view.*
import net.apptimystic.appoflife.R

class TaskViewHolder(var itemV: View): RecyclerView.ViewHolder(itemV), ChecklistRVMVP.ChecklistView {

    companion object {
        val viewType = 1
        fun inflate(parent: ViewGroup): TaskViewHolder {
            return TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_task, parent, false))
        }
    }

    override fun setDesc(desc: String) {
        itemV.tvDesc.text = desc
    }
}