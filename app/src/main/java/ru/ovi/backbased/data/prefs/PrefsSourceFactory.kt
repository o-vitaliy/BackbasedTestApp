package ru.perevozka24.perevozka24.data.prefs

import android.content.Context
import android.content.SharedPreferences

object PrefsSourceFactory {
    fun create(context: Context): SharedPreferences = context.getSharedPreferences(
        context.packageName,
        Context.MODE_PRIVATE
    )
}
