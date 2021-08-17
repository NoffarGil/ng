package com.jb.couponsys.repos;
import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    List<Coupon> findByCompanyIdAndCategory(int companyId, Category category);
    List<Coupon> findByCompanyIdAndPriceLessThan(int companyId, double price);
    boolean existsByCategory(Category category);
}
