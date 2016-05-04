package com.notes.rest.service.callbacks;

import com.notes.db.models.core.Subject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pkonwar on 5/3/2016.
 */
public class SubjectImageCallback implements Callback<ResponseBody>{

    private Subject subject;

    public SubjectImageCallback(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        byte[] subjectImageBytes = null;
        try {
            if(response.body() != null) {
                subjectImageBytes = response.body().bytes();
                byte[] originalSubjectImageBytes = subject.getImageBlob();
                if(originalSubjectImageBytes == null) {
                    System.out.println("Trying to save an image");
                    subject.setImageBlob(subjectImageBytes);
                    subject.save();
                    System.out.println("Saved Image");
                } else {
                    System.out.println("Image for subject " + subject.getSubjectName() + " already present" );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

    }
}
