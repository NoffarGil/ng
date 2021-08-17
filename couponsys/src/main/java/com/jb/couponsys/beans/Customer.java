package com.jb.couponsys.beans;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "customers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany
    @Singular
    private List<Coupon> coupons = new ArrayList<>();


}
