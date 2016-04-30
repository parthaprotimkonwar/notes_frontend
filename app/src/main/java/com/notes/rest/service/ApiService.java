package com.notes.rest.service;

import com.notes.models.core.question_answers.Question;
import com.notes.rest.beans.QuestionBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pkonwar on 4/30/2016.
 */
public interface ApiService {

    @GET(value = "questions")
    public Call<List<QuestionBean>> getQuestions();
}
