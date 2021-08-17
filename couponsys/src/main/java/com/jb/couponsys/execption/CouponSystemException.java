package com.jb.couponsys.execption;

public class CouponSystemException extends Exception{
    public CouponSystemException(ErrMsg errMsg) {
        super(errMsg.getDescription());
    }
}
