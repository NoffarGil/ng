package com.jb.couponsys.mapper;

import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.beans.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Optional;


@Mapper(componentModel = "spring")
public interface CouponMapper {

    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    void updateCouponFromDto(Coupon couponDto, @MappingTarget Optional<Coupon> entity);
}