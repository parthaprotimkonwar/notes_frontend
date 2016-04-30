package com.notes.models.core.question_answers;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.models.core.Module;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Table(name = "MODULE_QUESTIONS_ANSWERS")
public class ModuleQuestionsAnswers extends Model {

    public ModuleQuestionsAnswers() {
    }

    @Column(name = "QUESTION_ANSWER")
    private QuestionsAnswer questionsAnswer;

    @Column(name = "MODULE")
    private Module module;

    @Column(name = "INDEXING", unique = true, notNull = true)
    private Integer indexing;

}
