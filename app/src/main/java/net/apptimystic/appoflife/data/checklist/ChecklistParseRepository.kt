package net.apptimystic.appoflife.data.checklist

import android.util.Log
import io.reactivex.Single
import net.apptimystic.appoflife.data.task.ParseTask
import rx.parse2.ParseObservable


class ChecklistParseRepository: ChecklistRepository {

    override fun getChecklist(name: String): Single<Checklist> {
        Log.d("atom", "requesting checklist")
        val query = ParseTask.getQuery().whereEqualTo("checklist", name)
        return ParseObservable.find(query)
                .map { it.toTask() }
                .toList()
                .map { Checklist(it, name) }
    }
}