package net.apptimystic.appoflife.data.checklist

import io.reactivex.Observable
import io.reactivex.Single
import net.apptimystic.appoflife.data.task.Task

class ChecklistMockRepository: ChecklistRepository {

    override fun getChecklist(name: String): Single<Checklist> {
        return Single.just(createMockChecklist(5, name))
    }

    override fun getChecklistDirectory(): Observable<Checklist> {
        return Observable.range(1, 5)
                .map { createMockChecklist(5, "checklist$it") }
    }

    private fun createMockChecklist(count: Int, name: String): Checklist {
        return Observable.range(1, count)
                .map({ Task("item $it in checklist $name", name) })
                .toList()
                .map { Checklist(it) }
                .blockingGet()
    }
}