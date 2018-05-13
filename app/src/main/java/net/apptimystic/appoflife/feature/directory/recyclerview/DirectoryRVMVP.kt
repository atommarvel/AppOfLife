package net.apptimystic.appoflife.feature.directory.recyclerview

import net.apptimystic.appoflife.feature.recyclerview.RVPresenter

interface DirectoryRVMVP {
    interface ChecklistView {
        fun setName(name: String)
    }

    interface Presenter: RVPresenter
}