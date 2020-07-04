package ru.ovi.backbased.presentation.common

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackBar(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val v = view ?: return
    Snackbar.make(v, message, length).show()
}

fun Context.showAlert(
    message: String,
    title: String? = null,
    doOnDismiss: (() -> Unit)? = null
): AlertDialog {
    return AlertDialog.Builder(this)
        .setMessage(message)
        .setTitle(title)
        .setOnDismissListener { doOnDismiss?.invoke() }.show()
}

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    activity?.toast(message, length)
}

fun View.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    context?.toast(message, length)
}
