package net.apptimystic.appoflife.feature.directory.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cell_checklist.view.*
import net.apptimystic.appoflife.R
import net.apptimystic.appoflife.feature.recyclerview.RVPresenter


class ChecklistViewHolder(var itemV: View, val presenter: RVPresenter): RecyclerView.ViewHolder(itemV), DirectoryRVMVP.ChecklistView {

    companion object {
        val viewType = 1
        fun inflate(parent: ViewGroup, presenter: RVPresenter): ChecklistViewHolder {
            return ChecklistViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_checklist, parent, false), presenter)
        }
    }

    init {
        itemV.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                presenter.onItemClick(position)
            }
        }
    }

    override fun setName(name: String) {
        itemV.tvName.text = name
    }
}