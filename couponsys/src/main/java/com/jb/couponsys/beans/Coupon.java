package com.jb.couponsys.beans;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;
@Data
@Entity
@Table(name = "coupons")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.ORDINAL)
    private Category category;
    @ManyToOne
    @ToString.Exclude
    private Company company;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int amount;
    private double price;
    private String image;
}
