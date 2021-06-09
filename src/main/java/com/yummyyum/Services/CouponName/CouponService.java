package com.yummyyum.Services.CouponName;

import com.yummyyum.Model.Coupon;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CouponService {

    List<Coupon> getAllCoupons();

    List<Coupon> getAllActiveCoupons();

    List<Coupon> getAllInactiveCoupons();

    List<Coupon> getAllCouponsByIsActive(Boolean isActive);

    Optional<Coupon> getCouponByCouponName(String couponName);

    Coupon createCoupon(String couponName, Float percentageDiscount, Float fixedAmountDiscount,
                        Boolean isActive, Date activationDate, Date deactivationDate);

    Coupon updateCoupon(String couponName, Float percentageDiscount, Float fixedAmountDiscount,
                        Boolean isActive, Date activationDate, Date deactivationDate, String oldCouponName);

}
