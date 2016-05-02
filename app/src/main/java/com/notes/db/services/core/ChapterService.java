package com.notes.db.services.core;

import com.activeandroid.query.Select;
import com.notes.db.models.core.Chapter;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class ChapterService {

    public static Chapter findAChapter(Long chapterId) {
        return new Select().from(Chapter.class).where("CHAPTER_ID = ?", chapterId).executeSingle();
    }

}
