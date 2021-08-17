package com.jb.couponsys.services;

import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Customer;
import com.jb.couponsys.execption.CouponSystemException;
import com.jb.couponsys.execption.ErrMsg;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl extends ClientService implements AdminService{
    @Override
    public void addCompany(Company company) throws CouponSystemException {

        if(companyRepository.existsByEmail(company.getEmail())){
            throw new CouponSystemException(ErrMsg.COMPANY_EMAIL_EXIST);
        }
        if(companyRepository.existsByName(company.getName())){
            throw new CouponSystemException(ErrMsg.COMPANY_NAME_EXIST);
        }

        this.companyRepository.save(company);
    }

    @Override
    public void updateCompany(int companyId, Company company) throws CouponSystemException {

        if(!this.companyRepository.existsById(companyId)){
            throw new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST);
        }
        if(!this.companyRepository.getById(companyId).getName().equals(company.getName())){
            throw new CouponSystemException(ErrMsg.CAN_NOT_UPDATE_COMPANY_NAME);
        }

        Optional<Company> companyToUpdate = companyRepository.findById(companyId);
        this.companyMapper.updateCompanyFromDto(company, companyToUpdate);
        this.companyRepository.saveAndFlush(companyToUpdate.get());
    }

    @Override
    public void deleteCompany(int companyId) throws CouponSystemException {
        Company companyToDelete = this.companyRepository.getById(companyId);
        if (companyToDelete == null){
            throw new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST);
        }
        this.companyRepository.deleteById(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }

    @Override
    public Company getSingleCompany(int companyId) throws CouponSystemException {
        if(!this.companyRepository.existsById(companyId)){
            throw new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST);
        }
        return this.companyRepository.getById(companyId);
    }

    @Override
    public void addCustomer(Customer customer) throws CouponSystemException {
        if(customerRepository.existsByEmail(customer.getEmail())){
            throw new CouponSystemException(ErrMsg.CUSTOMER_EMAIL_EXIST);
        }
        this.customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) throws CouponSystemException {
        if(!this.customerRepository.existsById(customerId)){
            throw new CouponSystemException(ErrMsg.CUSTOMER_ID_NOT_EXIST);
        }
        Optional<Customer> customerToUpdate = customerRepository.findById(customerId);
        this.customerMapper.updateCustomerFromDto(customer, customerToUpdate);
        this.customerRepository.saveAndFlush(customerToUpdate.get());
    }

    @Override
    public void deleteCustomer(int customerId) throws CouponSystemException {
        Customer customerToDelete = this.customerRepository.getById(customerId);
        if (customerToDelete == null){
            throw new CouponSystemException(ErrMsg.CUSTOMER_NOT_EXIST);
        }
        this.companyRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer getSingleCustomer(int customerId) throws CouponSystemException {
        if(!this.customerRepository.existsById(customerId)){
            throw new CouponSystemException(ErrMsg.CUSTOMER_ID_NOT_EXIST);
        }
        return this.customerRepository.getById(customerId);
     }

    @Override
    public boolean login(String email, String password) {
        return email.equals("admin@admin.com") && password.equals("admin");
    }
}
