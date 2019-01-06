// B"H
package shmulik.coupons_manager.final_project.controllers.rolls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import shmulik.coupons_manager.final_project.Exeptions.CouponAlreadytExsitException;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.services.rolls.interfaces.CompanyFacade;

@RestController
@RequestMapping("/rest/api/company")
public class CompanyController {

    @Autowired
    private CompanyFacade companyFacade;

    @PostMapping("/createNewCoupon")
    public Coupon createNewCoupon (@RequestBody Coupon coupon, @RequestParam("companyID") long companyID){
        try {
            return companyFacade.createNewCoupon(coupon, companyID );
        } catch (DataIntegrityViolationException e) {
            String str = e.getMostSpecificCause().getMessage().split("'")[1];
            throw new CouponAlreadytExsitException("Coupon title '" + str + "' is not unique.");
        }
    }

    @DeleteMapping("/deleteCoupon/{id}")
    public boolean deleteCoupon(@PathVariable("id") long couponID){
        return companyFacade.deleteCoupon(couponID);
    }

    @PostMapping("/updateCouponExpireDate")
    public Coupon updateCouponExpireDate(@RequestBody Coupon coupon)  {
        return companyFacade.updateCouponExpireDate(coupon.getId(), coupon.getEndDate());
    }

    @PostMapping("/updateCouponPrice")
    public Coupon updateCouponPriceDate(@RequestBody Coupon coupon)  {
        return companyFacade.updateCouponPrice(coupon.getId(), coupon.getPrice());
    }
//
//    @PostMapping("/addCouponToCustomer")
//    public Coupon addCouponToCustomer(@RequestParam("couponID") long couponID, @RequestParam("customerID") long customerID) {
//        return customerFacade.addCouponToCustomer(couponID,customerID);
//    }
//
//    @GetMapping("/getCouponsHistory/{id}")
//    public Set<Coupon> getCouponsHistory(@PathVariable("id") int id){
//        return customerFacade.getCouponsHistory(id);
//    }
//
//    @PostMapping("/getCouponUpToPrice")
//    public Set<Coupon> getCouponUpToPrice(@RequestParam("customerID") long customerID, @RequestParam("price") double price){
//        return  customerFacade.getCouponUpToPrice(customerID, price);
//    }
//
//    @PostMapping("/getCouponbyType")
//    public Set<Coupon> getCouponbyType(@RequestParam("customerID") long customerID, @RequestParam("category") String category){
//        return  customerFacade.getCouponbyType(customerID, category);
//    }

//    @PostMapping("/addCouponToCustomer")
//    public Coupon addCouponToCustomer(@RequestParam("couponID") long couponID, @RequestParam("customerID") long customerID) {
//        try {
//            return companyFacade. .addCouponToCustomer(couponID,customerID);
//        } catch (NullPointerException e){
//            throw new CouponOrCustomerNotExistException("Either Coupon or Customer are not exist in the system.");
//        }
//    }
}
