package com.jb.couponsys.job;

import com.jb.couponsys.repos.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponRemoval {
    private final CouponRepository couponRepository;

    @Scheduled(fixedRate = 1000*60*60*24)
    public void yalla(){
       /* couponRepository.delete
                deleteAll();*/
    }
}
