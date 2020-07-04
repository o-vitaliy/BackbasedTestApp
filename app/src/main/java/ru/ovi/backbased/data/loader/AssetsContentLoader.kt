package ru.ovi.backbased.data.loader

import android.content.Context
import java.io.InputStream

/**
 * Utility class that loads data from assets
 * @property context application context.
 * @constructor Creates new instance of [AssetsContentLoader]
 */
class AssetsContentLoader(private val context: Context) : ContentLoader {

    /**
     * @see [ContentLoader.load]
     */
    override fun load(path: String): InputStream =
        context.assets.open(path)
}