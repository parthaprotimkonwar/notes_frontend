package com.notes.rest.bean.core;


import com.google.gson.annotations.Expose;
import com.notes.app.enums.STATUS;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class SubjectBean {

    public SubjectBean() {}

    public SubjectBean(Long subjectId) {
        this.subjectId = subjectId;
    }

    public SubjectBean(String subjectName, Float price, String imageUrl, STATUS status) {
        this.subjectName = subjectName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    public SubjectBean(Long subjectId, String subjectName, Float price, String imageUrl, STATUS status) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    @Expose
    private Long subjectId;
    @Expose
    private String subjectName;
    @Expose
    private Float price;
    @Expose
    private String imageUrl;            //this image url is to be changed to image blob
    @Expose
    private STATUS status;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}