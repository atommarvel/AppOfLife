package net.apptimystic.appoflife.todo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.android.synthetic.main.activity_todo.*
import net.apptimystic.appoflife.R

class TodoActivity : AppCompatActivity() {

    lateinit var itemAdapter: ItemAdapter<TodoItem>
    lateinit var fastAdapter: FastAdapter<TodoItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        setupRV()
    }

    fun setupRV() {
        itemAdapter = ItemAdapter()
        fastAdapter = FastAdapter.with(itemAdapter)
        rvTodos.setLayoutManager(LinearLayoutManager(this));
        rvTodos.adapter = fastAdapter
        itemAdapter.add(mockData())
    }

    fun mockData(): List<TodoItem> {
        val list = mutableListOf<TodoItem>()
        for (i in 1..5) {
            val item = TodoItem()
            item.todo = Todo("item number $i")
            list.add(item)
        }
        return list
    }
}
