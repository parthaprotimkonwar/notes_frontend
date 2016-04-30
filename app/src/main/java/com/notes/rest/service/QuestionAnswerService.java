package com.notes.rest.service;

import com.notes.rest.dto.QuestionAnswerDto;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pkonwar on 4/30/2016.
 */
public interface QuestionAnswerService {

    @GET(value = "question/answer/course")
    public Call<QuestionAnswerDto> questionAnswers();

    /*@GET(value = "questions")
    public Call<List<QuestionBean>> questions();

    @GET(value = "answers")
    public Call<List<AnswerBean>> answers();

    @GET(value = "questionanswer")
    public Call<List<QuestionAnswerBean>> questionAnswer();

    @GET(value = "questionoptions")
    public Call<List<QuestionOptionsBean>> questionOptions();

    @GET(value = "modulequestionanswers")
    public Call<List<ModuleQuestionsAnswersBean>> moduleQuestionAnswer();*/
}
