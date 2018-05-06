package net.apptimystic.appoflife.ktx

import android.support.design.widget.Snackbar
import android.view.View

inline fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}