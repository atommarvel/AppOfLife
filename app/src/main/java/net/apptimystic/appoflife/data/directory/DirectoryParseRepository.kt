package net.apptimystic.appoflife.data.directory

import io.reactivex.Single
import net.apptimystic.appoflife.data.checklist.ParseChecklist
import rx.parse2.ParseObservable

class DirectoryParseRepository: DirectoryRepository {
    override fun getDirectory(): Single<Directory> {
        val query = ParseChecklist.getQuery()
        val checklists = ParseObservable.find(query)
                .map { it.toChecklist() }
                .toList()
                .blockingGet()

        return Single.just(checklists)
    }
}