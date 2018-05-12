package net.apptimystic.appoflife.data.checklist

import io.reactivex.Observable
import io.reactivex.Single

interface ChecklistRepository {
    fun getChecklist(name: String): Single<Checklist>
    fun getChecklistDirectory(): Observable<Checklist>
}