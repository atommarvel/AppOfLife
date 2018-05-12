package net.apptimystic.appoflife.feature.checklist.recyclerview

import net.apptimystic.appoflife.feature.recyclerview.RVPresenter

interface ChecklistRVMVP {
    interface ChecklistView {
        fun setDesc(desc: String)
    }

    interface Presenter: RVPresenter
}