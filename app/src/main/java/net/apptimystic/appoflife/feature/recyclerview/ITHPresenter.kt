package net.apptimystic.appoflife.feature.recyclerview

interface ITHPresenter {
    fun movementFlags(itemViewType: Int?): Int
    fun itemSwiped(position: Int?)
}