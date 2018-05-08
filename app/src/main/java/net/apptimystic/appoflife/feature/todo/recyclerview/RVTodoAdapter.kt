package net.apptimystic.appoflife.feature.todo.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import net.apptimystic.appoflife.feature.recyclerview.RVPresenter
import net.apptimystic.appoflife.feature.todo.recyclerview.HeaderViewHolder
import net.apptimystic.appoflife.feature.todo.recyclerview.TodoViewHolder
import java.lang.IllegalStateException


class RVTodoAdapter(private val presenter: RVPresenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        presenter.bindViewHolder(holder, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            HeaderViewHolder.viewType -> HeaderViewHolder.inflate(parent)
            TodoViewHolder.viewType -> TodoViewHolder.inflate(parent)
            else -> throw IllegalStateException("viewType $viewType is not covered")
        }
    }

    override fun getItemCount(): Int = presenter.getItemCount()

    override fun getItemViewType(position: Int): Int {
        return presenter.getItemType(position)
    }
}

//<T in RecyclerView.ViewHolder>(private val presenter: RVPresenter) : RecyclerView.Adapter<T>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
//        return RepositoryViewHolder(LayoutInflater.from(parent.context)
//                .inflate(R.layout.cell_repo_view, parent, false))
//    }
//
//    fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
//        presenter.onBindRepositoryRowViewAtPosition(position, holder)
//
//    }
//
//    override fun getItemCount(): Int {
//        return presenter.getRepositoriesRowsCount()
//    }
//}