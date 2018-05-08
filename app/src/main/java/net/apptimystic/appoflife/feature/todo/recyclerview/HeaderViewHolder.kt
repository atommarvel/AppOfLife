package net.apptimystic.appoflife.feature.todo.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cell_header.view.*
import net.apptimystic.appoflife.R

class HeaderViewHolder(var itemV: View): RecyclerView.ViewHolder(itemV), RVTodoMVP.HeaderView {

    companion object {
        val viewType = 2
        fun inflate(parent: ViewGroup): HeaderViewHolder {
            return HeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_header, parent, false))
        }
    }

    override fun setLabel(label: String) {
        itemV.tvLabel.text = label
    }

}