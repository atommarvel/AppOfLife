package net.apptimystic.appoflife.feature.checklist

import io.reactivex.Single
import net.apptimystic.appoflife.data.checklist.Checklist
import net.apptimystic.appoflife.feature.checklist.recyclerview.ChecklistRVMVP
import net.apptimystic.appoflife.feature.recyclerview.ITHPresenter
import java.lang.ref.WeakReference

interface ChecklistMVP {

    interface View {
        fun updateData(viewModel: ChecklistViewModel)
        fun showSnackBar(msg: String)
    }

    interface Presenter: ChecklistRVMVP.Presenter, ITHPresenter {
        var view: WeakReference<ChecklistMVP.View>

        fun loadChecklist(name: String)
        fun rxUnsubscribe()
    }

    interface Model {
        fun result(name: String): Single<Checklist>
    }
}

data class ChecklistViewModel(var checklist: Checklist = Checklist())