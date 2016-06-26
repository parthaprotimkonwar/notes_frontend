package com.notes.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.notes.rest.service.CoreServices;

import java.lang.reflect.Modifier;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pkonwar on 4/30/2016.
 */
public class RestClient {
    private static final String BASE_URL = "http://192.168.0.101:9000/";

    private CoreServices coreServices;

    public RestClient() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        coreServices = retrofit.create(CoreServices.class);
    }

    public CoreServices getCoreServices() {
        return coreServices;
    }
}
