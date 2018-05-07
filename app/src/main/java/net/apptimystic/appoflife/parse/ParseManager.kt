package net.apptimystic.appoflife.parse

import android.content.Context
import com.parse.Parse
import com.parse.ParseObject
import net.apptimystic.appoflife.data.todo.ParseTodo


class ParseManager {

    fun initParse(context: Context) {
        registerParseObjects()
        Parse.initialize(Parse.Configuration.Builder(context)
                .applicationId("")
                .server("")
                .build())
    }

    private fun registerParseObjects() {
        ParseObject.registerSubclass(ParseTodo::class.java)
    }
}