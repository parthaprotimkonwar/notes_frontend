package com.notes.db.services.core;

import com.activeandroid.query.Select;
import com.notes.db.models.core.Author;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class AuthorService {

    public static Author findAAuthor(Long authorId) {
        return new Select().from(Author.class).where("AUTHOR_ID = ?", authorId).executeSingle();
    }
}
