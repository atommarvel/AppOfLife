package net.apptimystic.appoflife.feature.todo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_todo.*
import net.apptimystic.appoflife.core.App
import net.apptimystic.appoflife.R
import net.apptimystic.appoflife.feature.todo.recyclerview.RVTodoAdapter
import net.apptimystic.appoflife.ktx.snack
import java.lang.ref.WeakReference
import javax.inject.Inject

class TodoActivityView : AppCompatActivity(), TodoActivityMVP.View {

    @Inject lateinit var presenter: TodoActivityMVP.Presenter
    lateinit var rvAdapter: RVTodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        (application as App).component?.inject(this)
        setupRV()
    }

    fun setupRV() {

        rvTodos.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()
        presenter.view = WeakReference(this)
        presenter.loadData()
    }

    override fun updateData(viewModel: TodoViewModel) {
        rvAdapter = RVTodoAdapter(presenter)
        rvTodos.adapter = rvAdapter
    }

    override fun showSnackBar(msg: String) {
        rvTodos.snack(msg)
    }
}
