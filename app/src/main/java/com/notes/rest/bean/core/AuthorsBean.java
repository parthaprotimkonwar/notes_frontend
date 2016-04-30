package com.notes.rest.bean.core;


import com.google.gson.annotations.Expose;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class AuthorsBean{

    public AuthorsBean() {}

    public AuthorsBean(Long authorId) {
        this.authorId = authorId;
    }

    public AuthorsBean(String authorName, String authorDescription) {
        this.authorName = authorName;
        this.authorDescription = authorDescription;
    }

    @Expose
    private Long authorId;
    @Expose
    private String authorName;
    @Expose
    private String authorDescription;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }
}
