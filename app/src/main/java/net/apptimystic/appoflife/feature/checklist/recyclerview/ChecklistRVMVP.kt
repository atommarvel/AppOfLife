package net.apptimystic.appoflife.feature.checklist.recyclerview

import net.apptimystic.appoflife.feature.recyclerview.RVPresenter

interface ChecklistRVMVP {
    interface TaskView {
        fun setDesc(desc: String)
    }

    interface Presenter: RVPresenter
}