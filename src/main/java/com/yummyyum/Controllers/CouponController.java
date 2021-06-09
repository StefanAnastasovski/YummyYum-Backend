package com.yummyyum.Controllers;

import com.yummyyum.Model.Coupon;
import com.yummyyum.Services.CouponName.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/coupon")
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    @GetMapping("/coupon/coupon-name={couponName}")
    public Optional<Coupon> getCouponByCouponName(@PathVariable("couponName") String couponName) {
        return couponService.getCouponByCouponName(couponName);
    }

    @GetMapping("/coupon/active")
    public List<Coupon> getAllActiveCoupons() {
        return couponService.getAllActiveCoupons();
    }

    @GetMapping("/coupon/inactive")
    public List<Coupon> getAllInactiveCoupons() {
        return couponService.getAllInactiveCoupons();
    }

    @GetMapping("/coupon/test/active={active}")
    public List<Coupon> getAllInactiveCoupons(@PathVariable("active") Boolean active) {
        return couponService.getAllCouponsByIsActive(active);
    }

    @PostMapping("/coupon")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Coupon createNewCoupon(@RequestBody Coupon coupon,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        return couponService.createCoupon(coupon.getCouponName(),
                coupon.getPercentageDiscount(), coupon.getFixedAmountDiscount(),
                coupon.getIsActive(), coupon.getActivationDate(), coupon.getDeactivationDate());
    }

    @PutMapping("/coupon/coupon-name={couponName}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Coupon updateCoupon(@RequestBody Coupon coupon,
                             @PathVariable("couponName") String couponName,
                             HttpServletResponse response,
                             UriComponentsBuilder builder) {

        return couponService.updateCoupon(coupon.getCouponName(),
                coupon.getPercentageDiscount(), coupon.getFixedAmountDiscount(),
                coupon.getIsActive(), coupon.getActivationDate(), coupon.getDeactivationDate(), couponName);
    }
}
