package net.apptimystic.appoflife.feature.directory

import io.reactivex.Single
import net.apptimystic.appoflife.data.directory.Directory
import net.apptimystic.appoflife.data.directory.DirectoryRepository

class DirectoryModel(val repository: DirectoryRepository): DirectoryMVP.Model {

    override fun result(): Single<Directory> {
        return repository.getDirectory()
    }
}