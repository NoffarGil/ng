package com.jb.couponsys.repos;

import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByEmail(String email);

}
