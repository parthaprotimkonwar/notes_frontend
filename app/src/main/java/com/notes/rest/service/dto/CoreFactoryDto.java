package com.notes.rest.service.dto;

import com.google.gson.annotations.Expose;
import com.notes.rest.bean.core.AuthorsBean;
import com.notes.rest.bean.core.ChapterBean;
import com.notes.rest.bean.core.ModuleBean;
import com.notes.rest.bean.core.SubjectAuthorBean;
import com.notes.rest.bean.core.SubjectBean;

import java.util.List;

/**
 * Created by pkonwar on 4/30/2016.
 */
public class CoreFactoryDto {

    @Expose
    public List<SubjectBean> subjects;

    @Expose
    public List<ChapterBean> chapters;

    @Expose
    public List<ModuleBean> modules;

    @Expose
    public List<AuthorsBean> authors;

    @Expose
    public List<SubjectAuthorBean> subjectAuthor;
}
