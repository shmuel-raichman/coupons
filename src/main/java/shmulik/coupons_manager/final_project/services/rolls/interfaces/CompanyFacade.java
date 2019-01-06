// B"H
package shmulik.coupons_manager.final_project.services.rolls.interfaces;

import shmulik.coupons_manager.final_project.entities.Coupon;

import java.util.Date;


public interface CompanyFacade {

    Coupon createNewCoupon(Coupon coupon, long companyID);

    boolean deleteCoupon(long couponID);

    Coupon updateCouponExpireDate(long couponID, Date date);

    Coupon updateCouponPrice(long couponID, double price);
}
