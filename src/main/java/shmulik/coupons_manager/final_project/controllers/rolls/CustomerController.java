// B"H
package shmulik.coupons_manager.final_project.controllers.rolls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shmulik.coupons_manager.final_project.messages.Exeptions.CouponOrCustomerNotExistException;
import shmulik.coupons_manager.final_project.messages.Exeptions.CustomerNotFoundException;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.CustomerFacade;

import java.util.Set;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;

    @PostMapping("/addCouponToCustomer")
    public Coupon addCouponToCustomer(@RequestParam("couponID") long couponID, @RequestParam("customerID") long customerID) {
        try {
            return customerFacade.addCouponToCustomer(couponID,customerID);
        } catch (NullPointerException e){
            throw new CouponOrCustomerNotExistException("Either Coupon or Customer are not exist in the system.");
        }
    }

    @GetMapping("/getCouponsHistory/{id}")
    public Set<Coupon> getCouponsHistory(@PathVariable("id") int id){
         try {
             return customerFacade.getCouponsHistory(id);
         } catch (NullPointerException e){
             throw new CustomerNotFoundException("There is no customer with the give id.");
         }
    }

    @PostMapping("/getCouponUpToPrice")
    public Set<Coupon> getCouponUpToPrice(@RequestParam("customerID") long customerID, @RequestParam("price") double price){
        return  customerFacade.getCouponUpToPrice(customerID, price);
    }

    @PostMapping("/getCouponbyType")
    public Set<Coupon> getCouponbyType(@RequestParam("customerID") long customerID, @RequestParam("category") String category){
        return  customerFacade.getCouponbyType(customerID, category);
    }
}
