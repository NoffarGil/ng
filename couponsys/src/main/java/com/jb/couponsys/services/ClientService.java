package com.jb.couponsys.services;

import com.jb.couponsys.mapper.CompanyMapper;
import com.jb.couponsys.mapper.CouponMapper;
import com.jb.couponsys.mapper.CustomerMapper;
import com.jb.couponsys.repos.CompanyRepository;
import com.jb.couponsys.repos.CouponRepository;
import com.jb.couponsys.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {
    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected CouponRepository couponRepository;
    @Autowired
    protected CustomerRepository customerRepository;
    @Autowired
    protected CompanyMapper companyMapper;
    @Autowired
    protected CustomerMapper customerMapper;
    @Autowired
    protected CouponMapper couponMapper;

    public ClientService() {
    }

    public abstract boolean login(String email, String password);
}
