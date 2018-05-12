package net.apptimystic.appoflife.feature.checklist

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.support.v7.widget.helper.ItemTouchHelper.LEFT
import android.support.v7.widget.helper.ItemTouchHelper.RIGHT
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import net.apptimystic.appoflife.data.checklist.Checklist
import net.apptimystic.appoflife.data.checklist.MutableChecklist
import net.apptimystic.appoflife.feature.checklist.recyclerview.ChecklistRVMVP
import net.apptimystic.appoflife.feature.checklist.recyclerview.TaskViewHolder
import java.lang.ref.WeakReference
import javax.inject.Inject

class ChecklistPresenter @Inject constructor(var model: ChecklistMVP.Model) : ChecklistMVP.Presenter {

    var disposable: Disposable? = null
    override lateinit var view: WeakReference<ChecklistMVP.View>
    var viewModel: ChecklistViewModel? = null
    var activeChecklist: MutableChecklist = mutableListOf()

    override fun loadChecklist(name: String) {
        disposable = model
                .result(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::displayData, this::displayError)
    }

    private fun displayData(result: Checklist) {
        viewModel = ChecklistViewModel(result)
        activeChecklist.addAll(result)
        view.get()?.updateData(viewModel!!)
    }

    private fun displayError(error: Throwable) {
        view.get()?.showSnackBar(error.localizedMessage)
    }

    override fun rxUnsubscribe() {
        disposable?.dispose()
    }

    // Routine RecyclerView

    override fun bindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val task = activeChecklist[position]
        (viewHolder as ChecklistRVMVP.ChecklistView).setDesc(task.desc)
    }

    override fun getItemCount(): Int = activeChecklist.size

    override fun getItemType(position: Int): Int = TaskViewHolder.viewType

    // Swipe to dismiss

    override fun movementFlags(itemViewType: Int?): Int {
        return when(itemViewType) {
            TaskViewHolder.viewType -> return ItemTouchHelper.Callback.makeMovementFlags(0, LEFT or RIGHT)
            else -> 0
        }
    }

    override fun itemSwiped(position: Int?) {
        if (position != null) {
            activeChecklist.removeAt(position)
            view.get()?.updateData(viewModel!!)
        }
    }
}