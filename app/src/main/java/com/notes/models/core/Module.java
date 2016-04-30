package com.notes.models.core;

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

    public Module(Chapter chapter, String moduleName, Integer indexing, STATUS status) {
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

    @Column(name = "INDEXING", notNull = true, unique = true)
    private Integer indexing;

    @Column(name = "STATUS")
    private STATUS status;

}