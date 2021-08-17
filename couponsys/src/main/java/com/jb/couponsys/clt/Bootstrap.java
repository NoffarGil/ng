package com.jb.couponsys.clt;

import com.jb.couponsys.beans.Category;
import com.jb.couponsys.beans.Company;
import com.jb.couponsys.beans.Coupon;
import com.jb.couponsys.beans.Customer;
import com.jb.couponsys.util.Art;
import com.jb.couponsys.repos.CompanyRepository;
import com.jb.couponsys.repos.CouponRepository;
import com.jb.couponsys.repos.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@Order(1)
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CouponRepository couponRepository;
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("start create foundation...");
        System.out.println(Art.CUSTOMER);
        Company colaComp = Company.builder()
                .email("cola@gmail.com")
                .name("coca cola")
                .password("1234")
                .clearCoupons()
                .build();
        Company neviotComp = Company.builder()
                .email("neviot@gmail.com")
                .name("neviot")
                .password("1234")
                .clearCoupons()
                .build();
        Company isrotelComp = Company.builder()
                .email("isrotel@gmail.com")
                .name("isrotel")
                .password("1234")
                .clearCoupons()
                .build();
        companyRepository.saveAll(Arrays.asList(colaComp,neviotComp,isrotelComp));
        companyRepository.findAll().forEach(System.out::println);
        System.out.println(Art.INSERT);
        //System.out.println("insert");
        Company comp4 = Company.builder()
                .name("Comp4")
                .email("comp@gmail.com")
                .password("1234")
                .build();
        companyRepository.saveAndFlush(comp4);
        companyRepository.findAll().forEach(System.out::println);

        Customer gayaCust = Customer.builder()
                .email("gaya@gmail.com")
                .password("1234")
                .firstName("gaya")
                .lastName("gaya")
                .build();

        Customer galCust = Customer.builder()
                .email("gal@gmail.com")
                .password("1234")
                .firstName("gal")
                .lastName("gal")
                .build();

        Customer giliCust = Customer.builder()
                .email("gili@gmail.com")
                .password("1234")
                .firstName("gili")
                .lastName("gili")
                .build();
        System.out.println(Art.CUSTOMER);
        customerRepository.saveAll(Arrays.asList(galCust,gayaCust,giliCust));
        customerRepository.findAll().forEach(System.out::println);
        System.out.println(Art.UPDATE);
        gayaCust = customerRepository.getById(1);
        gayaCust.setFirstName("noffar");
        gayaCust.setLastName("gil");
        customerRepository.saveAndFlush(gayaCust);

        System.out.println(customerRepository.getById(1));
        System.out.println(Art.DELETE);
        customerRepository.deleteById(2);
        customerRepository.findAll().forEach(System.out::println);
        System.out.println();

        System.out.println(Art.COUPON);
        Coupon coupon1 = Coupon.builder()
                .amount(100)
                .title("1+1")
                .image("http://blabla.com")
                .category(Category.VACATION)
                .company(companyRepository.getById(2))
                .description("description")
                .title("title")
                .price(5_000)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(14)))
                .build();
        Coupon coupon2 = Coupon.builder()
                .amount(1_000)
                .title("2+1")
                .image("http://blabla.com")
                .category(Category.FOOD)
                .company(companyRepository.getById(2))
                .description("description")
                .title("title")
                .price(5.9)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(14)))
                .build();
        couponRepository.saveAll(Arrays.asList(coupon1, coupon2));
        couponRepository.findAll().forEach(System.out::println);


    }
}
