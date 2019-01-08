// B"H
package shmulik.coupons_manager.final_project.services.rolls.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.Scheduling.ScheduledTasks;
import shmulik.coupons_manager.final_project.entities.Company;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.services.interfaces.CompanyService;
import shmulik.coupons_manager.final_project.services.interfaces.CouponService;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.CompanyFacade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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

    public Set<Coupon> getAllCouponsForCompany(long companyID){
        return companyService.findById(companyID).getCoupons();
    }

    public Set<Coupon> getCouponsForCompanyByPrice(long customerID, double price){
        Company company = companyService.findById(customerID);
        Set<Coupon> coupons = company.getCoupons();
        Set<Coupon> couponsMoreThen = new HashSet<>();
        coupons.forEach(coupon -> {
            if(coupon.getPrice() <= price) {
                couponsMoreThen.add(coupon);
            }
        });
        return couponsMoreThen;
    }

    public Set<Coupon> getCouponsForCompanyByType(long companyID, String category){
        final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
        Company company = companyService.findById(companyID);
        logger.info("Current Thread : {}", Thread.currentThread().getName());
        Set<Coupon> coupons = company.getCoupons();
        Set<Coupon> couponsMoreThen = new HashSet<>();
        coupons.forEach(coupon -> {
            if(coupon.getCouponCategory().toString().equals(category)) {
                couponsMoreThen.add(coupon);
            }
        });
        return couponsMoreThen;
    }

    public Set<Coupon> getCouponsForCompanyByEndDate(long companyID, Date date){
        Company company = companyService.findById(companyID);
        Set<Coupon> coupons = company.getCoupons();
        Set<Coupon> couponsMoreThen = new HashSet<>();
        coupons.forEach(coupon -> {
            if(coupon.getEndDate() != null && !coupon.getEndDate().after(date)) {
                couponsMoreThen.add(coupon);
            }
//            coupon.getEndDate().toString().equals(date.toString())
        });
        return couponsMoreThen;
    }

    public Company getMyCompany(long id){
        return companyService.findById(id);
    }
}