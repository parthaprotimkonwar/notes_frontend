package com.notes.rest.service.callbacks;

import android.util.Log;

import com.notes.db.models.core.Author;
import com.notes.db.models.core.Chapter;
import com.notes.db.models.core.Module;
import com.notes.db.models.core.Subject;
import com.notes.db.models.core.SubjectAuthor;
import com.notes.db.services.core.AuthorService;
import com.notes.db.services.core.ChapterService;
import com.notes.db.services.core.ModuleService;
import com.notes.db.services.core.SubjectAuthorService;
import com.notes.db.services.core.SubjectService;
import com.notes.rest.RestClient;
import com.notes.rest.bean.core.AuthorsBean;
import com.notes.rest.bean.core.ChapterBean;
import com.notes.rest.bean.core.ModuleBean;
import com.notes.rest.bean.core.SubjectAuthorBean;
import com.notes.rest.bean.core.SubjectBean;
import com.notes.rest.service.dto.CoreFactoryDto;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class CoreFactorySetingsCallback implements Callback<CoreFactoryDto> {
    @Override
    public void onResponse(Call<CoreFactoryDto> call, Response<CoreFactoryDto> response) {
        CoreFactoryDto factory = response.body();
        Log.d("NOTES", "HAIL! " + factory.chapters.toString());

        //Populate Subject in the database
        List<SubjectBean> subjectBeanList = factory.subjects;
        for(SubjectBean subjectBean : subjectBeanList) {
            Subject subject = SubjectService.findASubject(subjectBean.getSubjectId());
            if(subject == null) {
                subject = new Subject(subjectBean.getSubjectId(), subjectBean.getSubjectName(), subjectBean.getPrice(), null, subjectBean.getStatus());
                subject.save();    //save this subject in db
            } else {
                System.out.println("Subject with detials " + subject.getSubjectName() + " already present.");
            }
            if(subject!= null && subject.getImageBlob() == null) {
                //Get the image from a url and save it. Done at a later point of time as this operation can be performed parallely
                RestClient client = new RestClient();
                Call<ResponseBody> responseBody = client.getCoreServices().downloadImage("assets/" + subjectBean.getImageUrl());
                responseBody.enqueue(new SubjectImageCallback(subject));
            }
        }

        //Populate Chapter data in the database
        List<ChapterBean> chapterBeansList = factory.chapters;
        for(ChapterBean chapterBean : chapterBeansList) {
            Chapter chapter = ChapterService.findAChapter(chapterBean.getChapterId());

            if(chapter == null) {
                Subject subject = SubjectService.findASubject(chapterBean.getSubjectId());
                if(subject != null) {
                    chapter = new Chapter(chapterBean.getChapterId(), chapterBean.getPrice(), chapterBean.getChapterName(), chapterBean.getIndexing(), subject, chapterBean.getStatus());
                    chapter.save();
                    System.out.println("saving a chapter with name : " + chapter.getChapterName());
                } else {
                    System.out.println("Subject with Id : " + chapterBean.getSubjectId() + " not present");
                }
            }
        }
        //Populate Module data in the database
        List<ModuleBean> moduleBeanList = factory.modules;
        for(ModuleBean moduleBean : moduleBeanList) {
            Module module = ModuleService.findAModule(moduleBean.getModuleId());
            if(module == null) {
                Chapter chapter = ChapterService.findAChapter(moduleBean.getChapterId());
                if(chapter != null) {
                    module = new Module(moduleBean.getModuleId(), chapter, moduleBean.getModuleName(), moduleBean.getIndexing(), moduleBean.getStatus());
                    module.save();          //save the module
                    System.out.println("Module with id : " + module.getModuleName() + " saved");
                }
            }
        }

        //Populate Authors in the database
        List<AuthorsBean> authorsBeanList = factory.authors;
        for(AuthorsBean authorsBean : authorsBeanList) {
            Author author = AuthorService.findAAuthor(authorsBean.getAuthorId());
            if(author == null) {
                author = new Author(authorsBean.getAuthorId(), authorsBean.getAuthorName(), authorsBean.getAuthorDescription());
                author.save();      //saving the author
                System.out.println("Saved a Author : " + author.getAuthorName());
            }
        }

        //Populate Subject Authors in the database
        List<SubjectAuthorBean> subjectAuthorBeanList = factory.subjectAuthor;
        for(SubjectAuthorBean subjectAuthorBean : subjectAuthorBeanList) {
            Subject subject = SubjectService.findASubject(subjectAuthorBean.getSubjectId());
            Author author = AuthorService.findAAuthor(subjectAuthorBean.getAuthorId());
            // For Many to Many relationship using the internal id used for mapping.
            SubjectAuthor subjectAuthor = SubjectAuthorService.findASubjectAuthor(subject.getId(), author.getId());
            if(subjectAuthor == null && subject !=null && author !=null) {

                subjectAuthor = new SubjectAuthor(subject, author);
                subjectAuthor.save();     //save a subject author
                System.out.println("Saved a subject Author");
            }
        }

    }

    @Override
    public void onFailure(Call<CoreFactoryDto> call, Throwable t) {
        Log.d("NOTES", "MAY DAY! Core Factory" + t.getMessage() + t.fillInStackTrace());
    }
}
