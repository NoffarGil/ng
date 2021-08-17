package com.jb.couponsys.services;


import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.execption.CouponSystemException;
import com.jb.couponsys.execption.ErrMsg;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
//@Scope(Prototype)
public class CompanyServiceImple extends ClientService implements CompanyService{

    private int companyID;

    @Override
    public boolean login(String email, String password) {
        if(this.companyRepository.existsByEmailAndPassword(email, password)){
            this.companyID = this.companyRepository.findByEmailAndPassword(email, password).getId();
            return true;
        }
        return false;
    }

    @Override
    public void addCoupon(Coupon coupon) throws CouponSystemException {
       // if()


    }

    @Override
    public void updateCoupon(int couponId,Coupon coupon) throws CouponSystemException {

        if(!this.couponRepository.existsById(couponId)){
            throw new CouponSystemException(ErrMsg.COUPON_ID_NOT_EXIST);
        }
        if (this.couponRepository.getById(couponId).getCompany().getId() != coupon.getCompany().getId()){
            throw new CouponSystemException(ErrMsg.CAN_NOT_UPDATE_COMPANY_ID);
        }

        Optional<Coupon> couponToUpdate = couponRepository.findById(couponId);
        this.couponMapper.updateCouponFromDto(coupon, couponToUpdate);
        this.couponRepository.saveAndFlush(couponToUpdate.get());
    }

    @Override
    public void deleteCoupon(int companyId) throws CouponSystemException {

    }

    @Override
    public List<Coupon> getCompanyCoupons() throws CouponSystemException {
        if(!this.companyRepository.existsById(this.companyID)){
            throw new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST);
        }
        return this.companyRepository.getById(this.companyID).getCoupons();
    }

    @Override
    public List<Coupon> getCompanyCoupons(Category category) throws CouponSystemException {
        if(!this.companyRepository.existsById(this.companyID)){
            throw new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST);
        }
        return this.couponRepository.findByCompanyIdAndCategory(this.companyID, category);
    }

    @Override
    public List<Coupon> getCompanyCoupons(double maxPrice) throws CouponSystemException {
        if(!this.companyRepository.existsById(this.companyID)){
            throw new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST);
        }
        return this.couponRepository.findByCompanyIdAndPriceLessThan(this.companyID, maxPrice);    }

    @Override
    public Company getCompanyDetails() throws CouponSystemException {
        if(!this.companyRepository.existsById(this.companyID)){
            throw new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST);
        }
        return this.companyRepository.getById(this.companyID);
    }
}
