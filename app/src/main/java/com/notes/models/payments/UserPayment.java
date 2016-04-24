package com.notes.models.payments;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.models.users.User;


/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "USER_PAYMENT")
public class UserPayment extends Model{

    @Column(name = "USERID_PAYMENTID", unique = true, notNull = true, index = true)
    private Long userIdPaymentId;

    @Column(name = "USER_ID")
    private User userId;

    @Column(name = "PAYMENT_ID")
    private Payment paymentId;

    public UserPayment() {
    }


}
