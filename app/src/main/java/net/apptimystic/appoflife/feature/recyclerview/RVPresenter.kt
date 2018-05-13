package net.apptimystic.appoflife.feature.recyclerview

import android.support.v7.widget.RecyclerView

interface RVPresenter {
    fun bindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int)
    fun getItemCount(): Int
    fun getItemType(position: Int): Int
    fun onItemClick(position: Int)
}