package com.notes.rest.service.dto;

import com.google.gson.annotations.Expose;
import com.notes.rest.bean.core.question_answers.AnswerBean;
import com.notes.rest.bean.core.question_answers.ModuleQuestionsAnswersBean;
import com.notes.rest.bean.core.question_answers.QuestionAnswerBean;
import com.notes.rest.bean.core.question_answers.QuestionOptionsBean;
import com.notes.rest.bean.core.question_answers.QuestionBean;

import java.util.List;

/**
 * Created by pkonwar on 4/30/2016.
 */
public class QuestionAnswerDto {

    @Expose
    public List<QuestionBean> questions;

    @Expose
    public List<AnswerBean> answers;

    @Expose
    public List<QuestionAnswerBean> questionAnswer;

    @Expose
    public List<QuestionOptionsBean> questionOptions;

    @Expose
    public List<ModuleQuestionsAnswersBean> moduleQuestionAnswer;

}
