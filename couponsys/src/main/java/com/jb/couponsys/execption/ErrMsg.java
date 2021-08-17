package com.jb.couponsys.execption;

public enum ErrMsg {

    COMPANY_NAME_EXIST("company name is already exist"),
    COMPANY_EMAIL_EXIST("company email is already exist"),
    COMPANY_ID_NOT_EXIST("company id not exist"),
    CAN_NOT_UPDATE_COMPANY_NAME("can't update company's name"),
    COMPANY_NOT_EXIST("company is not exist"),
    CAN_NOT_UPDATE_COMPANY_ID("can't update company id"),

    CUSTOMER_ID_NOT_EXIST("customer id not exist"),
    CUSTOMER_EMAIL_EXIST("customer email is already exist"),
    CUSTOMER_NOT_EXIST("customer is not exist"),
    COUPON_ID_NOT_EXIST("coupon id is not exist");


    private  String description;

    ErrMsg(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
