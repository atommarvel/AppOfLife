package net.apptimystic.appoflife.data.directory

import io.reactivex.Single

interface DirectoryRepository {
    fun getDirectory(): Single<Directory>
}