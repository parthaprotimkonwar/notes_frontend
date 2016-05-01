package com.notes.rest.service;

import com.notes.rest.dto.CoreFactoryDto;
import com.notes.rest.dto.QuestionAnswerDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by pkonwar on 4/30/2016.
 */
public interface CoreServices {

    @GET(value = "factory/courses/data")
    public Call<CoreFactoryDto> coreFactorySettings();

    @GET(value = "question/answers/{moduleId}")
    public Call<QuestionAnswerDto> questionAnswers(@Path("moduleId") Long moduleId);

    /*@GET(value = "questions")
    public Call<List<SubjectBean>> subjects();

    @GET(value = "chapters")
    public Call<List<ChapterBean>> chapters();

    @GET(value = "modules")
    public Call<List<ModuleBean>> modules();

    @GET(value = "authors")
    public Call<List<AuthorsBean>> authors();

    @GET(value = "subjectauthor")
    public Call<List<SubjectAuthorBean>> subjectAuthor();*/

}
