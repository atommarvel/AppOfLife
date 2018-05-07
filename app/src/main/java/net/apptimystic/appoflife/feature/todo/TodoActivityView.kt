package net.apptimystic.appoflife.feature.todo

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter_extensions.swipe.SimpleSwipeCallback
import kotlinx.android.synthetic.main.activity_todo.*
import net.apptimystic.appoflife.core.App
import net.apptimystic.appoflife.R
import net.apptimystic.appoflife.ktx.snack
import javax.inject.Inject

class TodoActivityView : AppCompatActivity(), TodoActivityMVP.View {

    lateinit var headerMorningAdapter: ItemAdapter<HeaderRVItem>
    lateinit var morningAdapter: ItemAdapter<TodoRVItem>
    lateinit var headerEveningAdapter: ItemAdapter<HeaderRVItem>
    lateinit var eveningAdapter: ItemAdapter<TodoRVItem>
    lateinit var fastAdapter: FastAdapter<TodoRVItem>
    @Inject lateinit var presenter: TodoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        (application as App).component?.inject(this)
        setupRV()
    }

    fun setupRV() {
        headerMorningAdapter = ItemAdapter()
        morningAdapter = ItemAdapter()
        headerEveningAdapter = ItemAdapter()
        eveningAdapter = ItemAdapter()

        fastAdapter = FastAdapter.with(listOf(headerMorningAdapter, morningAdapter, headerEveningAdapter, eveningAdapter))
        rvTodos.layoutManager = LinearLayoutManager(this)
        rvTodos.adapter = fastAdapter

        headerMorningAdapter.add(HeaderRVItem("Morning Routine"))
        headerEveningAdapter.add(HeaderRVItem("Evening Routine"))

        val touchCallback = SimpleSwipeCallback({ position: Int, direction: Int ->
            // TODO: call back into the presenter
            Log.d("atom", fastAdapter.getItem(position).todo?.desc)
            val info = fastAdapter.getRelativeInfo(position)
            (info.adapter as ItemAdapter).remove(info.position)
        }, ContextCompat.getDrawable(this, R.drawable.ic_done))
        val touchHelper = ItemTouchHelper(touchCallback)
        touchHelper.attachToRecyclerView(rvTodos)
    }

    override fun onResume() {
        super.onResume()
        presenter.view = this
        presenter.loadData()
    }

    override fun updateData(viewModel: TodoViewModel) {
        morningAdapter.add(viewModel.morningTodos.wrapForRV())
        eveningAdapter.add(viewModel.eveningTodos.wrapForRV())
    }

    override fun showSnackBar(msg: String) {
        rvTodos.snack(msg)
    }
}
