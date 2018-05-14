package net.apptimystic.appoflife.feature.directory

import android.support.v7.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import net.apptimystic.appoflife.data.directory.Directory
import net.apptimystic.appoflife.data.directory.DirectoryRepository
import net.apptimystic.appoflife.data.directory.MutableDirectory
import net.apptimystic.appoflife.feature.directory.recyclerview.ChecklistViewHolder
import net.apptimystic.appoflife.feature.directory.recyclerview.DirectoryRVMVP
import java.lang.ref.WeakReference

class DirectoryPresenter(var repo: DirectoryRepository): DirectoryMVP.Presenter {

    override lateinit var view: WeakReference<DirectoryMVP.View>
    var disposable: Disposable? = null
    var viewModel: DirectoryViewModel? = null
    var activeDirectoryList: MutableDirectory = mutableListOf()

    fun clearData() {
        viewModel = null
        activeDirectoryList = mutableListOf()
    }

    override fun loadDirectory() {
        clearData()
        disposable = repo.getDirectory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::displayData, this::displayError)
    }

    fun displayData(result: Directory) {
        viewModel = DirectoryViewModel(result)
        activeDirectoryList.addAll(result)
        view.get()?.updateData(viewModel!!)
    }

    private fun displayError(error: Throwable) {
        view.get()?.showSnackBar(error.localizedMessage)
    }

    override fun rxUnsubscribe() {
        disposable?.dispose()
    }

    // RecyclerView

    override fun bindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val checklist = activeDirectoryList[position]
        (viewHolder as DirectoryRVMVP.ChecklistView).setName(checklist.name)
    }

    override fun getItemCount(): Int = activeDirectoryList.size

    override fun getItemType(position: Int): Int = ChecklistViewHolder.viewType

    override fun onItemClick(position: Int) {
        val checklist = activeDirectoryList[position]
        view.get()?.displayChecklist(checklist)
    }
}