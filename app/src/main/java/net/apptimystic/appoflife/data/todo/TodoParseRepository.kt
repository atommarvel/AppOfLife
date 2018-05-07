package net.apptimystic.appoflife.data.todo

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseQuery
import io.reactivex.Single
import rx.parse2.ParseObservable
import kotlin.reflect.KProperty


class TodoParseRepository: TodoRepository {

    override fun getTodoItems(): Single<List<Todo?>> {
        return ParseObservable.find(ParseTodo.getQuery())
                .map { it.toTodo() }
                .toList()
    }
}

@ParseClassName("RoutineAction")
class ParseTodo: ParseObject() {
    var description: String? by ParsePropString("description")
    var group: String? by ParsePropString("group")

    companion object {
        fun getQuery(): ParseQuery<ParseTodo> {
            return ParseQuery.getQuery(ParseTodo::class.java)
        }
    }

    fun toTodo(): Todo? {
        return if (description != null && group != null) {
            Todo(description!!, group!!)
        } else {
            null
        }
    }

    inner class ParsePropString(val key: String) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String? = getString(key)
        operator fun setValue(thisRef: Any?, property: KProperty<*>, s: String?) = put(key, s)
    }
}