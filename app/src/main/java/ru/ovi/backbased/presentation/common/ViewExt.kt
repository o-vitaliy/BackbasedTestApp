package ru.ovi.backbased.presentation.common

import android.view.View

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) = visible(value)

fun View.visible(value: Boolean, invisibility: Int = View.GONE) {
    visibility = if (value) View.VISIBLE else invisibility
}

fun showOnly(toShow: View, vararg toHide: View) {
    toShow.visible = true
    toHide.forEach {
        it.visible = false
    }
}

fun showOnly(root: View, show: Int, vararg toHide: Int) {
    root.findViewById<View>(show).visible = true
    toHide.forEach {
        root.findViewById<View>(it).visible = false
    }
}
