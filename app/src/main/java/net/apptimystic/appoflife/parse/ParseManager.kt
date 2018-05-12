package net.apptimystic.appoflife.parse

import android.content.Context
import com.parse.Parse
import com.parse.ParseObject
import net.apptimystic.appoflife.data.task.ParseTask


class ParseManager {

    fun initParse(context: Context) {
        registerParseObjects()
        Parse.initialize(Parse.Configuration.Builder(context)
                .applicationId("L5f8SKNA6Elv")
                .server("http://parse.atom.fyi/parse/")
                .build())
    }

    private fun registerParseObjects() {
        ParseObject.registerSubclass(ParseTask::class.java)
    }
}