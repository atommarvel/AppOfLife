package net.apptimystic.appoflife.data.directory

import io.reactivex.Single
import net.apptimystic.appoflife.data.checklist.Checklist
import net.apptimystic.appoflife.data.checklist.ChecklistMockRepository

class DirectoryMockRepository: DirectoryRepository {

    override fun getDirectory(): Single<Directory> {
        return Single.just(getMockDirectory())
    }

    fun getMockDirectory(): Directory {
        return listOf(
                Checklist()
        )
    }
}