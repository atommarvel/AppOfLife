package net.apptimystic.appoflife.data.todo

import android.util.Log
import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseQuery
import io.reactivex.Observable
import net.apptimystic.appoflife.parse.ParsePropDelegate
import rx.parse2.ParseObservable


class TodoParseRepository: TodoRepository {

    override fun getTodoItems(): Observable<Todo> {
        Log.d("atom", "requesting items")
        return ParseObservable.find(ParseTodo.getQuery())
                .map { it.toTodo() }
    }
}

@ParseClassName("RoutineAction")
class ParseTodo: ParseObject() {
    var description: String? by ParsePropDelegate("description", ::getString, ::put)
    var group: String? by ParsePropDelegate("group", ::getString, ::put)

    companion object {
        fun getQuery(): ParseQuery<ParseTodo> {
            return ParseQuery.getQuery(ParseTodo::class.java)
        }
    }

    // TODO: Find a good way to pass optionals if a property is missing. Then filter out nulls.
    fun toTodo(): Todo = Todo(description!!, group!!)
}