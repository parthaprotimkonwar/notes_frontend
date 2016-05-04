package com.notes.rest.service;

import com.notes.rest.service.dto.CoreFactoryDto;
import com.notes.rest.service.dto.QuestionAnswerDto;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by pkonwar on 4/30/2016.
 */
public interface CoreServices {

    @GET(value = "factory/courses/data")
    public Call<CoreFactoryDto> coreFactorySettings();

    @GET(value = "question/answers/{moduleId}")
    public Call<QuestionAnswerDto> questionAnswers(@Path("moduleId") Long moduleId);

    /**
     * Download image assets
     * @param url
     * @return
     */
    @GET
    public Call<ResponseBody> downloadImage(@Url String url);

}
