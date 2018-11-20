package shmulik.coupons_manager.final_project.services;

import shmulik.coupons_manager.final_project.entities.Coupon;

import java.util.List;

public interface CouponService {

    List<Coupon> findAllItems();

    Coupon findItemById(long itemId);

    Coupon createCoupon(Coupon coupon);
}
