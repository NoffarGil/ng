package com.jb.couponsys.repos;
import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    List<Coupon> findByCompanyIdAndCategory(int companyId, Category category);
    List<Coupon> findByCompanyIdAndPriceLessThan(int companyId, double price);
    boolean existsByCategory(Category category);
    @Modifying
    @Transactional
    @Query(value =
            "DELETE FROM couponsystem.customers_coupons " +
                    "WHERE customers_coupons.customer_id = :customerId " +
                    "AND customers_coupons.coupons_id = :couponsId"
            , nativeQuery = true)
    void deleteCustomerCouponByCustomerIdAndCouponId(@Param("customerId") int customerId, @Param("couponsId") int couponsId);

}
