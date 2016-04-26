package com.notes.models.users;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.models.core.Chapter;

import java.util.Date;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "USERS_CHAPTERS")
public class UserChapter extends Model {

    public UserChapter() {
    }

    @Column(name = "USER", onDelete = Column.ForeignKeyAction.CASCADE)
    private User user;

    @Column(name = "CHAPTER", onDelete = Column.ForeignKeyAction.CASCADE)
    private Chapter chapter;

    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;



}