package net.apptimystic.appoflife.data.directory

import io.reactivex.Single
import net.apptimystic.appoflife.data.checklist.Checklist
import net.apptimystic.appoflife.data.checklist.MutableChecklist
import net.apptimystic.appoflife.data.task.ParseTask
import rx.parse2.ParseObservable

class DirectoryParseRepository: DirectoryRepository {
    override fun getDirectory(): Single<Directory> {
        val query = ParseTask.getQuery()
        val tasks = ParseObservable.find(query)
                .map { it.toTask() }
                .toList()
                .blockingGet()

        // TODO: move this logic to rxjava
        val mutableMap: MutableMap<String, MutableChecklist> =  mutableMapOf()

        fun ensureChecklist(name: String) {
            if (!mutableMap.containsKey(name)) {
                mutableMap[name] = MutableChecklist(name = name)
            }
        }

        tasks.forEach { task ->
            val checklistName = task.checklist
            ensureChecklist(checklistName)
            mutableMap[checklistName]?.add(task)
        }

        return Single.just(mutableMap.map { Checklist(it.value, it.key) })
    }


}