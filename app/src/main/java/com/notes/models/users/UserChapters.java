package com.notes.models.users;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.models.core.Chapter;

import java.util.Date;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "USER_CHAPTERS")
public class UserChapters extends Model {

    public UserChapters() {
    }

    @Column(name = "USERID_CHAPTERID", notNull = true, unique = true, index = true)
    private Long userIdChapterId;

    @Column(name = "USER")
    private User user;

    @Column(name = "CHAPTER")
    private Chapter chapter;

    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

}