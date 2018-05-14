package net.apptimystic.appoflife.data.checklist

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseQuery
import net.apptimystic.appoflife.parse.ParsePropDelegate
import org.json.JSONArray

@ParseClassName("Checklist")
class ParseChecklist: ParseObject() {
    var name: String? by ParsePropDelegate("name", ::getString, ::put)
    var tasks: JSONArray? by ParsePropDelegate("tasks", ::getJSONArray, ::put)

    companion object {
        fun getQuery(): ParseQuery<ParseChecklist> {
            return ParseQuery.getQuery(ParseChecklist::class.java)
        }
    }

    fun toChecklist() = Checklist(name = name!!, id = this.objectId)
}