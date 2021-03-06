package com.notes.db.models.payments;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "PAYMENTS")
public class Payment extends Model {

    @Column(name = "PAYMENT_ID", notNull = true, unique = true, index = true)
    private Long paymentId;

    @Column(name = "PAYMENT_GATEWAY_NAME", notNull = true, unique = true, length = 20)
    private String paymentGatewayName;

    @Column(name = "PAYMENT_GATEWAY_PARAMS")
    private String paymentGatewayParams;

    private List<UserPayment> userPaymentList;

    public List<UserPayment> getUserPaymentList() {
        return getMany(UserPayment.class, "PAYMENT");
    }
}