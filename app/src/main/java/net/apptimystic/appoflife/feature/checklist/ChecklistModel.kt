package net.apptimystic.appoflife.feature.checklist

import io.reactivex.Single
import net.apptimystic.appoflife.data.checklist.Checklist
import net.apptimystic.appoflife.data.checklist.ChecklistRepository

class ChecklistModel(var repository: ChecklistRepository) : ChecklistMVP.Model {
    override fun result(name: String): Single<Checklist> {
        return repository.getChecklist(name)
    }
}