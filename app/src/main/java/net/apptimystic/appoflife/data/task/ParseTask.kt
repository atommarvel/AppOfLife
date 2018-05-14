package net.apptimystic.appoflife.data.task

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseQuery
import net.apptimystic.appoflife.parse.ParsePropDelegate

@ParseClassName("Task")
class ParseTask: ParseObject() {
    var description: String? by ParsePropDelegate("description", ::getString, ::put)
    var checklist: String? by ParsePropDelegate("checklist", ::getString, ::put)

    companion object {
        fun getQuery(): ParseQuery<ParseTask> {
            return ParseQuery.getQuery(ParseTask::class.java)
        }
    }

    // TODO: Find a good way to pass optionals if a property is missing. Then filter out nulls.
    fun toTask(): Task = Task(description!!, checklist!!)
}