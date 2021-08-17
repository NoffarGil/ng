package com.jb.couponsys.services;

import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Customer;
import com.jb.couponsys.execption.CouponSystemException;

import java.util.List;

public interface AdminService {
    void addCompany(Company company) throws CouponSystemException;
    void updateCompany(int companyId, Company company) throws CouponSystemException;
    void deleteCompany(int companyId) throws CouponSystemException;

    List<Company> getAllCompanies();
    Company getSingleCompany(int companyId) throws CouponSystemException;

    void addCustomer(Customer customer) throws CouponSystemException;
    void updateCustomer(int customerId, Customer customer) throws CouponSystemException;
    void deleteCustomer(int customerId) throws CouponSystemException;

    List<Customer> getAllCustomers();
    Customer getSingleCustomer(int customerId) throws CouponSystemException;


}
