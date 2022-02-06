package com.gemmausiku.mythesis

object DataManager {             // Data Manager properties
    val chapters = HashMap<String, ChapterInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeChapters() //initializer block
        initializeNotes()
    }



    private fun initializeChapters() {
        var chapter = ChapterInfo("chapter 1", "Introduction")
        chapters.set(chapter.chapterId, chapter)

        chapter = ChapterInfo(chapterId = "chapter 2", title = "Literature Review")
        chapters.set(chapter.chapterId, chapter)

        chapter = ChapterInfo(chapterId = "chapter 3", title = "Methodology")
        chapters.set(chapter.chapterId, chapter)

        chapter = ChapterInfo("chapter 4", "Findings")
        chapters.set(chapter.chapterId, chapter)

        chapter = ChapterInfo("chapter 5", "Conclusion")
        chapters.set(chapter.chapterId, chapter)

    }

    private fun initializeNotes() {

        var chapter = chapters["chapter 1"]!!
        var note = NoteInfo(
            chapter,
            "Introduction",
            "This section is an introduction to the issues related to the study."
        )
        notes.add(note)

        note = NoteInfo(
            chapter,
            "Problem Statement",
            "This section describes the issues / problems to be studied in the research."
        )
        notes.add(note)

        chapter = chapters["chapter 2"]!!
        note = NoteInfo(
            chapter,
            "Literature Review",
            "Identify common topics, issues, or areas of focus"
        )
        notes.add(note)

        note = NoteInfo(
            chapter,
            "Main Body",
            "Summarizing research or articles in accordance " +
                    "with the relevance of references in the\n" +
                    "literature"
        )
        notes.add(note)

        chapter = chapters["chapter 3"]!!
        note = NoteInfo(chapter, "Methodology", "Research approach")
        notes.add(note)

        note = NoteInfo(
            chapter,
            "Introduction",
            "should discuss the methods used \n" +
                    "included according to the sequence of objectives of the study" +
                    " as stated in the first chapter.\n"
        )
        notes.add(note)

        chapter = chapters["chapter 4"]!!
        note = NoteInfo(
            chapter,
            "Findings",
            "This chapter presents and interprets the research data"
        )
        notes.add(note)

        note = NoteInfo(
            chapter,
            "Introduction",
            "The introduction in finding chapter should briefly discuss what is in the chapter"
        )
        notes.add(note)


        chapter = chapters["chapter 5"]!!
        note = NoteInfo(
            chapter,
            "Conclusion",
            "This chapter should briefly summarize the research findings"
        )
        notes.add(note)

        note = NoteInfo(
            chapter,
            "Future Research",
            "Suggestions for future research should also be included in this chapter."
        )
        notes.add(note)

    }



}






