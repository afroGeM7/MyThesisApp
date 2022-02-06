package com.gemmausiku.mythesis

data class ChapterInfo(val chapterId: String, val title: String) {
    override fun toString(): String {
        return title
    }
}

data class NoteInfo(
    var chapter: ChapterInfo? = null,
    var title: String? = null,
    var text: String? = null
)
