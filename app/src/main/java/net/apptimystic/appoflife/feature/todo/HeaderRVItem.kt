package net.apptimystic.appoflife.feature.todo

import android.support.annotation.NonNull
import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.cell_header.view.*
import net.apptimystic.appoflife.R

class HeaderRVItem(var headerLabel: String) : AbstractItem<HeaderRVItem, HeaderRVItem.ViewHolder>() {

    //The unique ID for this type of item
    override fun getType(): Int = R.id.header_cell
    //The layout to be used for this type of item
    override fun getLayoutRes(): Int = R.layout.cell_header
    override fun getViewHolder(@NonNull v: View): HeaderRVItem.ViewHolder = HeaderRVItem.ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<HeaderRVItem>(view) {
        var label: String? = null
            set(value) {
                itemView.tvLabel.text = value
            }

        override fun bindView(item: HeaderRVItem?, payloads: MutableList<Any>?) {
            label = item?.headerLabel
        }

        override fun unbindView(item: HeaderRVItem?) {
            label = null
        }
    }

}