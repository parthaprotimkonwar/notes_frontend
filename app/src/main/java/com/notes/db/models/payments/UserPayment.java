package com.notes.db.models.payments;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.db.models.users.User;


/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "USER_PAYMENT")
public class UserPayment extends Model{

    @Column(name = "USER")
    private User userId;

    @Column(name = "PAYMENT")
    private Payment payment;

    public UserPayment() {
    }


}
