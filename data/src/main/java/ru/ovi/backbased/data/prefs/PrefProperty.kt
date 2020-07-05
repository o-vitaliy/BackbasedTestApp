package ru.ovi.backbased.data.prefs

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PrefString<T : Any>(
    private val preferences: SharedPreferences,
    private val key: String,
    private val default: String?
) : ReadWriteProperty<T, String?> {

    override fun getValue(thisRef: T, property: KProperty<*>): String? {
        return preferences.getString(key, default)
    }

    override fun setValue(thisRef: T, property: KProperty<*>, value: String?) {
        preferences.edit {
            putString(key, value)
        }
    }
}

fun <T : Any> prefString(
    preferences: SharedPreferences,
    key: String,
    default: String? = null
): PrefString<T> =
    PrefString(preferences, key, default)

class PrefInt<T : Any>(
    private val preferences: SharedPreferences,
    private val key: String,
    private val default: Int
) : ReadWriteProperty<T, Int> {

    override fun getValue(thisRef: T, property: KProperty<*>): Int {
        return preferences.getInt(key, default)
    }

    override fun setValue(thisRef: T, property: KProperty<*>, value: Int) {
        preferences.edit {
            putInt(key, value)
        }
    }
}

fun <T : Any> prefInt(
    preferences: SharedPreferences,
    key: String,
    default: Int = 0
): PrefInt<T> =
    PrefInt(preferences, key, default)
