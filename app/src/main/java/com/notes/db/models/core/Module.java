package com.notes.db.models.core;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.app.enums.STATUS;


/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "MODULES")
public class Module extends Model {

    public Module() {
    }

    public Module(Long moduleId, Chapter chapter, String moduleName, Integer indexing, STATUS status) {
        this.moduleId = moduleId;
        this.chapter = chapter;
        this.moduleName = moduleName;
        this.indexing = indexing;
        this.status = status;
    }

    @Column(name = "MODULE_ID", unique = true, index = true, notNull = true)
    private Long moduleId;

    //onDelete means what will happen onDelete of Chapter
    @Column(name = "CHAPTER", onDelete = Column.ForeignKeyAction.CASCADE)
    private Chapter chapter;

    @Column(name = "MODULE_NAME")
    private String moduleName;

    @Column(name = "INDEXING", notNull = true)
    private Integer indexing;

    @Column(name = "STATUS")
    private STATUS status;

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
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
}