package com.notes.models.core;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.application.enums.STATUS;

/**
 * Created by pkonwar on 4/23/2016.
 */
@Table(name = "SUBJECT")
public class Subject extends Model {

    @Column(name = "SUBJECT_ID", unique = true, notNull = true)
    private Long subjectId;

    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "STATUS")
    private STATUS status;
}
