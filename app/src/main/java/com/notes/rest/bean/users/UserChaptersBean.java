package com.notes.rest.bean.users;

import java.util.Date;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class UserChaptersBean {

    private Long userId;
    private Long chapterId;
    private Date expirationDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}