package com.yummyyum.Services.CouponName.Impl;

import com.yummyyum.Model.Coupon;
import com.yummyyum.Repositories.CouponRepository;
import com.yummyyum.Services.CouponName.CouponService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public List<Coupon> getAllActiveCoupons() {
        return couponRepository.getAllActiveCoupons();
    }

    @Override
    public List<Coupon> getAllInactiveCoupons() {
        return couponRepository.getAllInactiveCoupons();
    }

    @Override
    public List<Coupon> getAllCouponsByIsActive(Boolean isActive) {
        return couponRepository.getAllCouponsByIsActive(true);
    }

    @Override
    public Optional<Coupon> getCouponByCouponName(String couponName) {
        return couponRepository.getCouponByCouponName(couponName);
    }

    @Override
    public Coupon createCoupon(String couponName, Float percentageDiscount,
                               Float fixedAmountDiscount, Boolean isActive, Date activationDate, Date deactivationDate) {
        Coupon coupon = null;

        coupon = new Coupon(couponName, percentageDiscount, fixedAmountDiscount, isActive,
                Objects.requireNonNullElseGet(activationDate, Date::new), deactivationDate);

        return couponRepository.save(coupon);
    }

    @Override
    public Coupon updateCoupon(String couponName, Float percentageDiscount,
                               Float fixedAmountDiscount, Boolean isActive,
                               Date activationDate, Date deactivationDate, String oldCouponName) {

        Optional<Coupon> coupon = couponRepository.getCouponByCouponName(oldCouponName);

        Coupon oldCoupon = null;
        Coupon newCoupon = new Coupon();

        if (coupon.isPresent()) {
            oldCoupon = coupon.get();
        } else {
            newCoupon.setCouponName(couponName);
            newCoupon.setPercentageDiscount(percentageDiscount);
            newCoupon.setFixedAmountDiscount(fixedAmountDiscount);
            newCoupon.setIsActive(isActive);
            newCoupon.setActivationDate(new Date());
            newCoupon.setDeactivationDate(deactivationDate);
        }

        newCoupon = oldCoupon;
        newCoupon.setCouponName(couponName);
        newCoupon.setPercentageDiscount(percentageDiscount);
        newCoupon.setFixedAmountDiscount(fixedAmountDiscount);
        newCoupon.setIsActive(isActive);
        newCoupon.setActivationDate(new Date());
        newCoupon.setDeactivationDate(deactivationDate);

        return couponRepository.saveAndFlush(newCoupon);
    }

}
