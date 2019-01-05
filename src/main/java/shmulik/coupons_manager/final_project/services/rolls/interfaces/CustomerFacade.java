// B"H
package shmulik.coupons_manager.final_project.services.rolls.interfaces;

import shmulik.coupons_manager.final_project.entities.Coupon;

import java.util.Set;

public interface CustomerFacade {

    //Customer addNewCustomer(Customer customer);

    //Customer updateCustomerEmail(long customerId, String email);

    //Customer updateCustomerPassword(long customerId, String email);

    Coupon addCouponToCustomer(long couponId, long customerId);

    Set<Coupon> getCouponsHistory(long customerID);

    Set<Coupon> getCouponUpToPrice(long customerID, double price);
}
