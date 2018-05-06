package net.apptimystic.appoflife.feature.todo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.android.synthetic.main.activity_todo.*
import net.apptimystic.appoflife.core.App
import net.apptimystic.appoflife.R
import net.apptimystic.appoflife.ktx.snack
import javax.inject.Inject

class TodoActivityView : AppCompatActivity(), TodoActivityMVP.View {

    lateinit var itemAdapter: ItemAdapter<TodoRVItem>
    lateinit var fastAdapter: FastAdapter<TodoRVItem>
    @Inject lateinit var presenter: TodoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        (application as App).component?.inject(this)
        setupRV()
    }

    fun setupRV() {
        itemAdapter = ItemAdapter()
        fastAdapter = FastAdapter.with(itemAdapter)
        rvTodos.setLayoutManager(LinearLayoutManager(this));
        rvTodos.adapter = fastAdapter
    }

    override fun onResume() {
        super.onResume()
        presenter.view = this
        presenter.loadData()
    }

    override fun updateData(viewModel: TodoViewModel) {
        itemAdapter.add(viewModel.todos.wrapForRV())
    }

    override fun showSnackBar(msg: String) {
        rvTodos.snack(msg)
    }
}
