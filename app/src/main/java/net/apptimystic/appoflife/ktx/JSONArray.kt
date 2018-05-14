package net.apptimystic.appoflife.ktx

import org.json.JSONArray

fun JSONArray.toMutableListString(): MutableList<String> {
    val items: MutableList<String> = mutableListOf()
    for (i in 0 until length()) {
        val id = getString(i)
        items.add(id)
    }
    return items
}