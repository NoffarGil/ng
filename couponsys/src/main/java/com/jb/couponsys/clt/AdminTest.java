package com.jb.couponsys.clt;

import com.jb.couponsys.repos.CompanyRepository;
import com.jb.couponsys.repos.CouponRepository;
import com.jb.couponsys.services.AdminService;
import com.jb.couponsys.services.AdminServiceImpl;
import com.jb.couponsys.util.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@RequiredArgsConstructor
public class AdminTest implements CommandLineRunner {
    private final AdminService adminService;
    private final CouponRepository couponRepository;
    private final CompanyRepository companyRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(Art.ADMIN);
        if (((AdminServiceImpl) adminService).login("admin@admin.com", "admin")) {
            System.out.println("admin logged on");
        } else {
            System.out.println("admin failed to logged on");
        }

    }
}