package com.notes.rest.bean.core;


import com.google.gson.annotations.Expose;
import com.notes.app.enums.STATUS;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class ModuleBean {

    public ModuleBean(Long moduleId) {
        this.moduleId = moduleId;
    }

    public ModuleBean(String moduleName, Long chapterId, Integer indexing, STATUS status) {
        this.moduleName = moduleName;
        this.chapterId = chapterId;
        this.indexing = indexing;
        this.status = status;
    }

    @Expose
    private Long moduleId;
    @Expose
    private Long chapterId;
    @Expose
    private String moduleName;
    @Expose
    private Integer indexing;
    @Expose
    private STATUS status;

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getIndexing() {
        return indexing;
    }

    public void setIndexing(Integer indexing) {
        this.indexing = indexing;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }
}
