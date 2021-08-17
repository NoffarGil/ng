package com.jb.couponsys.services;

import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.beans.Customer;
import com.jb.couponsys.execption.CouponSystemException;

import java.util.List;

public interface CompanyService {
    void addCoupon(Coupon coupon) throws CouponSystemException;
    void updateCoupon(int couponId, Coupon coupon) throws CouponSystemException;
    void deleteCoupon(int companyId) throws CouponSystemException;

    public List<Coupon> getCompanyCoupons() throws CouponSystemException;
    public List<Coupon> getCompanyCoupons(Category category) throws CouponSystemException;
    public List<Coupon> getCompanyCoupons(double maxPrice) throws CouponSystemException;
    public Company getCompanyDetails() throws CouponSystemException;
}
