package shmulik.coupons_manager.final_project.services.interfaces;

import shmulik.coupons_manager.final_project.entities.Coupon;

import java.util.List;

public interface CouponService {

    List<Coupon> findAll();

    Coupon findById(long itemId);

    Coupon createCoupon(Coupon coupon);

    Coupon updateCoupon(Coupon coupon);

    boolean deleteCouponById(long itemId);
}
