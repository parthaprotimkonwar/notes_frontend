package com.notes.models.users;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.application.enums.STATUS;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "USER")
public class User implements Serializable {

    public User() {
    }

    public User(String userName, String emailId, String phoneNo, String password, String deviceId, STATUS status) {
        this.userName = userName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.password = password;
        this.deviceId = deviceId;
        this.status = status;
    }

    @Column(name = "USER_ID", unique = true, notNull = true, index = true)
    private Long userId;

    @Column(name = "USER_NAME", length = 30)
    private String userName;

    @Column(name = "EMAIL_ID", length = 30, unique = true, notNull = true)
    private String emailId;

    @Column(name = "PHONE_NO", length = 15)
    private String phoneNo;

    @Column(name = "PASSWORD", notNull = true)
    private String password;

    @Column(name = "DEVICE_ID", length = 100, unique = true, notNull = true)
    private String deviceId;

    @Column(name = "STATUS")
    private STATUS status;

}
