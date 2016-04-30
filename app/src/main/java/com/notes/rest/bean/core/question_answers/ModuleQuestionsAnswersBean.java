package com.notes.rest.bean.core.question_answers;

import com.google.gson.annotations.Expose;

/**
 * Created by pkonwar on 4/17/2016.
 */
public class ModuleQuestionsAnswersBean {

    public ModuleQuestionsAnswersBean(Long questionsAnswerId, Long moduleId, Integer indexing) {
        this.questionsAnswerId = questionsAnswerId;
        this.moduleId = moduleId;
        this.indexing = indexing;
    }
    @Expose
    private Long questionsAnswerId;
    @Expose
    private Long moduleId;
    @Expose
    private Integer indexing;

    public Long getQuestionsAnswerId() {
        return questionsAnswerId;
    }

    public void setQuestionsAnswerId(Long questionsAnswerId) {
        this.questionsAnswerId = questionsAnswerId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getIndexing() {
        return indexing;
    }

    public void setIndexing(Integer indexing) {
        this.indexing = indexing;
    }
}
