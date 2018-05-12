package net.apptimystic.appoflife.feature.checklist

import io.reactivex.Single
import net.apptimystic.appoflife.data.checklist.ChecklistRepository

class ChecklistModel(var repository: ChecklistRepository) : ChecklistMVP.Model {

    // TODO: learn more rx to best split and rejoin as two lists. Groupby?
    override fun result(name: String): Single<ChecklistViewModel> {
        return repository.getChecklist(name)
                .map { ChecklistViewModel(it) }
    }
}