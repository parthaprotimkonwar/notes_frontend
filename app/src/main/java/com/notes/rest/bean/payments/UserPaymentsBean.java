package com.notes.rest.bean.payments;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class UserPaymentsBean {

    private Long userId;

    private Long paymentsId;

    public UserPaymentsBean(Long userId, Long paymentsId) {
        this.userId = userId;
        this.paymentsId = paymentsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPaymentsId() {
        return paymentsId;
    }

    public void setPaymentsId(Long paymentsId) {
        this.paymentsId = paymentsId;
    }
}
