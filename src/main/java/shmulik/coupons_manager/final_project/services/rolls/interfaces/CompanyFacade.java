// B"H
package shmulik.coupons_manager.final_project.services.rolls.interfaces;

import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.entities.Coupon;

import java.util.Date;
import java.util.Set;


public interface CompanyFacade {

    Coupon createNewCoupon(Coupon coupon, long companyID);

    boolean deleteCoupon(long couponID);

    Coupon updateCouponExpireDate(long couponID, Date date);

    Coupon updateCouponPrice(long couponID, double price);

    Set<Coupon> getAllCouponsForCompany(long companyID);

    Set<Coupon> getCouponsForCompanyByType(long companyID, String category);

    Set<Coupon> getCouponsForCompanyByPrice(long customerID, double price);

    Set<Coupon> getCouponsForCompanyByEndDate(long companyID, Date date);

    Company getMyCompany(long id);
}
