package com.jb.couponsys.beans;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private String email;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "company")
    //@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "company")
    @Singular
    @ToString.Exclude
    private List<Coupon> coupons = new ArrayList<>();
}
