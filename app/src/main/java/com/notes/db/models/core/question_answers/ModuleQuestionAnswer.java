package com.notes.db.models.core.question_answers;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.db.models.core.Module;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Table(name = "MODULE_QUESTIONS_ANSWERS")
public class ModuleQuestionAnswer extends Model {

    public ModuleQuestionAnswer() {
    }

    public ModuleQuestionAnswer(QuestionAnswer questionAnswer, Module module, Integer indexing) {
        this.questionAnswer = questionAnswer;
        this.module = module;
        this.indexing = indexing;
    }

    @Column(name = "QUESTION_ANSWER")
    private QuestionAnswer questionAnswer;

    @Column(name = "MODULE")
    private Module module;

    @Column(name = "INDEXING", notNull = true)
    private Integer indexing;

    public QuestionAnswer getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(QuestionAnswer questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Integer getIndexing() {
        return indexing;
    }

    public void setIndexing(Integer indexing) {
        this.indexing = indexing;
    }
}
