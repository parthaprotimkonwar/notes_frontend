package com.notes.models.core.question_answers;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "QUESTION")
public class Question extends Model {

    public Question() {
    }

    public Question(String question) {
        this.question = question;
    }

    @Column(name = "QUESTION_ID", unique = true, notNull = true)
    private Long questionId;

    @Column(name = "QUESTION", unique = true, notNull = true)
    private String question;


}
