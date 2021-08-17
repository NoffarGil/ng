package com.jb.couponsys.repos;

import com.jb.couponsys.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    boolean existsByEmail(String email);
    boolean existsByName(String name);
    boolean existsByEmailAndPassword(String email, String password);
    Company findByEmailAndPassword(String email, String password);

}
