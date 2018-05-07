package net.apptimystic.appoflife.parse

import kotlin.reflect.KProperty

class ParsePropDelegate<T: Any>(val key: String, val getMethod: (key: String) -> T, val putMethod: (key: String, Any) -> Unit) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T? = getMethod(key)
    operator fun setValue(thisRef: Any?, property: KProperty<*>, s: T?) =  s?.let { putMethod(key, it) }
}