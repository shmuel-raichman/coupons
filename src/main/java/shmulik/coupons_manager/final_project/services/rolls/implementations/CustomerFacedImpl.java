// B"H
package shmulik.coupons_manager.final_project.services.rolls.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.entities.Customer;
import shmulik.coupons_manager.final_project.services.interfaces.CustomerService;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.CustomerFacade;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerFacedImpl implements CustomerFacade {

//    @Autowired
//    private CouponRepo couponRepo;

    @Autowired
    private CustomerService customerService;

    public Coupon addCouponToCustomer(long couponId, long customerId){
        return customerService.addCouponToCustomer(couponId, customerId);
    }

    public Set<Coupon> getCouponsHistory(long customerID){
        Customer customer = customerService.findById(customerID);
        return customer.getCoupons();
    }

    public Set<Coupon> getCouponUpToPrice(long customerID, double price){
        Customer customer = customerService.findById(customerID);
        Set<Coupon> coupons = customer.getCoupons();
        Set<Coupon> couponsMoreThen = new HashSet<>();
        coupons.forEach(coupon -> {
            if(coupon.getPrice() <= price) {
                couponsMoreThen.add(coupon);
            }
        });
        return couponsMoreThen;
    }

    public Set<Coupon> getCouponbyType(long customerID, String category){
        Customer customer = customerService.findById(customerID);
        Set<Coupon> coupons = customer.getCoupons();
        Set<Coupon> couponsMoreThen = new HashSet<>();
        coupons.forEach(coupon -> {
            if(coupon.getCouponCategory().toString().equals(category)) {
                couponsMoreThen.add(coupon);
            }
        });
        return couponsMoreThen;
    }
}