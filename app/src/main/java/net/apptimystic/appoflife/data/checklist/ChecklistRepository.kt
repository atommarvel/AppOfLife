package net.apptimystic.appoflife.data.checklist

import io.reactivex.Single

interface ChecklistRepository {
    fun getChecklist(id: String): Single<Checklist>
}