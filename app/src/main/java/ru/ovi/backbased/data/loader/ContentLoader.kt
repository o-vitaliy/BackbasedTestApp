package ru.ovi.backbased.data.loader

import java.io.IOException
import java.io.InputStream

/**
 * Utility interface that describes loading data by provided path
 */
interface ContentLoader {
    /**
     * Loads InputStream of the content by provided [path]
     * @return content's InputStream
     * @throws IOException
     */
    @Throws(IOException::class)
    fun load(path: String): InputStream
}