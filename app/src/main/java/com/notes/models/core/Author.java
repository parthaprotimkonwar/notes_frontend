package com.notes.models.core;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "AUTHORS")
public class Author extends Model {

    public Author() {
    }

    public Author(String authorName, String authorDescription) {
        this.authorName = authorName;
        this.authorDescription = authorDescription;
    }

    @Column(name = "AUTHOR_ID", index = true, unique = true)
    private Long authorId;

    @Column(name = "AUTHOR_NAME", notNull = true)
    private String authorName;

    @Column(name = "AUTHOR_DESCRIPTION")
    private String authorDescription;

}
