// B"H
package shmulik.coupons_manager.final_project.services.rolls.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.services.interfaces.CompanyService;
import shmulik.coupons_manager.final_project.services.interfaces.CouponService;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.CompanyFacade;

import java.util.Date;


@Service
public class CompanyFacedImpl implements CompanyFacade {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CouponService couponService;

    public Coupon createNewCoupon(Coupon coupon, long companyID){
        return  companyService.createNewCoupon(coupon, companyID );
    }

    public boolean deleteCoupon(long couponID){
        return couponService.deleteCouponById(couponID);
    }

    public Coupon updateCouponExpireDate(long couponID, Date date){
        Coupon coupon = couponService.findById(couponID);
        coupon.setEndDate(date);
        couponService.updateCoupon(coupon);
        return coupon;
    }

    public Coupon updateCouponPrice(long couponID, double price){
        Coupon coupon = couponService.findById(couponID);
        coupon.setPrice(price);
        couponService.updateCoupon(coupon);
        return coupon;
    }

}