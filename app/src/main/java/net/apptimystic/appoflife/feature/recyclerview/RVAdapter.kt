package net.apptimystic.appoflife.feature.recyclerview

import android.support.v7.widget.RecyclerView

abstract class RVAdapter(val presenter: RVPresenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = presenter.getItemCount()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = presenter.bindViewHolder(holder, position)

    override fun getItemViewType(position: Int): Int = presenter.getItemType(position)
}