package net.apptimystic.appoflife.feature.directory

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_directory.*
import net.apptimystic.appoflife.R
import net.apptimystic.appoflife.core.App
import net.apptimystic.appoflife.data.checklist.Checklist
import net.apptimystic.appoflife.feature.checklist.ChecklistView
import net.apptimystic.appoflife.feature.directory.recyclerview.DirectoryRVAdapter
import net.apptimystic.appoflife.ktx.snack
import java.lang.ref.WeakReference
import javax.inject.Inject

class DirectoryView: AppCompatActivity(), DirectoryMVP.View {

    @Inject lateinit var presenter: DirectoryMVP.Presenter
    lateinit var rvAdapter: DirectoryRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directory)
        (application as App).component?.inject(this)
        setupRV()
    }

    fun setupRV() {
        rvChecklists.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        rvChecklists.addItemDecoration(decoration)
    }

    override fun onResume() {
        super.onResume()
        presenter.view = WeakReference(this)
        presenter.loadDirectory()
    }

    override fun onPause() {
        super.onPause()
        presenter.rxUnsubscribe()
    }

    override fun updateData(viewModel: DirectoryViewModel) {
        rvAdapter = DirectoryRVAdapter(presenter)
        rvChecklists.adapter = rvAdapter
        rvAdapter.notifyDataSetChanged()
    }

    override fun showSnackBar(msg: String) {
        rvChecklists.snack(msg)
    }

    override fun displayChecklist(checklist: Checklist) {
        val intent = Intent(this, ChecklistView::class.java)
        intent.putExtra("id", checklist.id)
        startActivity(intent)
    }
}