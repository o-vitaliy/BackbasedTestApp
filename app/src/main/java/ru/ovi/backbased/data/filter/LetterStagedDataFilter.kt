package ru.ovi.backbased.data.filter

import androidx.annotation.VisibleForTesting

/**
 * Implementation of data filtering.
 * Filtering works according to the following principle:
 * The search query is split into characters. Each character has its own [Stage].
 * [Stage] contains the filtered sublist, level (the first character has level 0,
 * the second - 1, etc.), and its character. To create stage's sublist the parent stage's list
 * is taken (for the root stage, the original list is taken), and it is filtered by matching the
 * stage's character to the character in list item at the level position.
 *
 * Improved performance is achieved by the fact that each subsequent character
 * uses the results of the previous filtering.
 *
 * Works only if data  is sorted. Does not sort data itself.
 *
 * Ex:
 * Given a list [aaa, aab, abb, bbb]
 * 1) user types "a"
 * query is "a"
 * Stage{
 *      level:0,
 *      char:"a",
 *      sublist:  [aaa, aab, abb],
 *      child: null
 *      }
 *
 * 2)user types "a",
 * query is "aa"
 * Stage{
 *      level:0,
 *      char:"a",
 *      sublist:  [aaa, aab, abb],
 *      child: Stage}
 *          level:1,
 *          char:"a",
 *          sublist:  [aaa, aab],
 *          child: null
 *          }
 *      }
 *
 * 2)user types "a",
 * query is "aaa"
 *
 * Stage{
 *      level:0,
 *      char:"a",
 *      sublist:  [aaa, aab, abb],
 *      child: Stage}
 *          level:1,
 *          char:"a",
 *          sublist:  [aaa, aab],
 *          child: Stage{level:2, char:"a", sublist:  [aaa] }
 *          }
 *      }
 */
class LetterStagedDataFilter<T : FilterPropertyProvider>(
    provider: FilterDataProvider<T>
) : DataFilter<T>(provider) {

    private var stage: Stage<T>? = null

    override fun filter(query: String?): Collection<T> {
        return if (query == null || query.isEmpty()) {
            stage = null
            data
        } else {
            val s = if (stage == null) {
                Stage(
                    0, query, filterListByLatter(
                        query[0],
                        0,
                        data
                    )
                )
            } else {
                rebuildOnQueryChange(0, query, stage!!)
            }
            stage = s
            s.getFilteredValue()
        }
    }

    private fun rebuildOnQueryChange(level: Int, query: String, stage: Stage<T>): Stage<T> {
        val child = stage.childStag?.let {
            if (level + 1 < query.length)
                rebuildOnQueryChange(level + 1, query, it)
            else null
        }
        return stage.copy(query = query).apply {
            childStag = child
        }
    }

    private data class Stage<T : FilterPropertyProvider>(
        val level: Int,
        val query: String,
        val values: Collection<T>
    ) {
        val levelChar = query[level]

        var childStag: Stage<T>? = null

        fun getFilteredValue(): Collection<T> {
            if (level == query.length - 1) {
                return values
            } else {
                var child = childStag
                if (child == null || child.levelChar != query[level + 1]) {
                    child = Stage(
                        level + 1,
                        query,
                        filterListByLatter(
                            query[level + 1],
                            level + 1,
                            values
                        )
                    )
                    childStag = child
                }
                return child.getFilteredValue()
            }
        }
    }


    companion object {
        private fun <T : FilterPropertyProvider> filterListByLatter(
            letter: Char,
            position: Int,
            list: Collection<T>
        ): List<T> {
            return if (list is List) {
                filterListByLatter(letter, position, list)
            } else {
                filterListByLatter(letter, position, ArrayList(list))
            }
        }

        @VisibleForTesting
        fun <T : FilterPropertyProvider> filterListByLatter(
            letter: Char,
            position: Int,
            list: List<T>
        ): List<T> {
            var startIndex = -1
            var endIndex = -1

            var startFound = false

            val iterator = list.iterator()

            val l = letter.toLowerCase()

            var i = 0
            while (iterator.hasNext()) {
                val title = iterator.next().filterProperty()
                if (title.length > position) {
                    val valueLatter = title[position].toLowerCase()

                    if (valueLatter == l) {
                        if (!startFound) {
                            startIndex = i
                            startFound = true
                        }
                        endIndex = i
                    } else {
                        if (startFound) {
                            break
                        }
                    }
                } else {
                    if (startFound) break
                }
                i++
            }

            return if (startIndex in 0..endIndex) {
                list.subList(startIndex, endIndex + 1)
            } else {
                emptyList()
            }
        }
    }
}
