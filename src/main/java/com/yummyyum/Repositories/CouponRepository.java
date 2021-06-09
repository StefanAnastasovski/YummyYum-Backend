package com.yummyyum.Repositories;

import com.yummyyum.Model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query(value = "SELECT * FROM coupon as c WHERE c.coupon_name = :couponName",
            nativeQuery = true)
    Optional<Coupon> getCouponByCouponName(String couponName);

    @Query(value = "SELECT * FROM coupon as c WHERE c.isActive = true",
            nativeQuery = true)
    List<Coupon> getAllActiveCoupons();

    @Query(value = "SELECT * FROM coupon as c WHERE c.isActive = false",
            nativeQuery = true)
    List<Coupon> getAllInactiveCoupons();

    List<Coupon> getAllCouponsByIsActive(Boolean isActive);

}
