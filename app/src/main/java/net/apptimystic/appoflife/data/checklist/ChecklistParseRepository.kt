package net.apptimystic.appoflife.data.checklist

import android.util.Log
import com.parse.ParseObject
import io.reactivex.Single
import net.apptimystic.appoflife.data.task.ParseTask
import net.apptimystic.appoflife.data.task.Task
import net.apptimystic.appoflife.ktx.toMutableListString
import rx.parse2.ParseObservable


class ChecklistParseRepository: ChecklistRepository {

    override fun getChecklist(id: String): Single<Checklist> {
        Log.d("atom", "requesting checklist")
        val query = ParseChecklist.getQuery()
        return ParseObservable.get(ParseChecklist::class.java, id)
                .map { fetchAllTasks(it) }
                .map { Checklist(it.blockingGet()) }
    }

    private fun fetchAllTasks(parseChecklist: ParseChecklist): Single<List<Task>> {
        val tasks: List<ParseTask> = parseChecklist.tasks!!.toMutableListString()
                .map { ParseObject.createWithoutData(ParseTask::class.java, it) }
        return ParseObservable.fetch(tasks)
                .map { it.toTask() }
                .toList()
    }
}