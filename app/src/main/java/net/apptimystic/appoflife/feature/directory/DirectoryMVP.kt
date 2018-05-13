package net.apptimystic.appoflife.feature.directory

import io.reactivex.Single
import net.apptimystic.appoflife.data.checklist.Checklist
import net.apptimystic.appoflife.data.directory.Directory
import net.apptimystic.appoflife.feature.directory.recyclerview.DirectoryRVMVP
import java.lang.ref.WeakReference

interface DirectoryMVP {

    interface View {
        fun updateData(viewModel: DirectoryViewModel)
        fun showSnackBar(msg: String)
        fun displayChecklist(checklist: Checklist)
    }

    interface Presenter: DirectoryRVMVP.Presenter {
        var view: WeakReference<DirectoryMVP.View>

        fun loadDirectory()
        fun rxUnsubscribe()
    }

    interface Model {
        fun result(): Single<Directory>
    }
}

data class DirectoryViewModel(var directory: Directory = listOf())