// B"H
package shmulik.coupons_manager.final_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shmulik.coupons_manager.final_project.entities.Coupon;
import shmulik.coupons_manager.final_project.services.interfaces.CouponService;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/api/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;


    @GetMapping
    public List<Coupon> findAllItems() {
        return couponService.findAll();
    }

    @GetMapping("{id}")
    public Coupon findItemById(@PathVariable("id") int itemId){
        return couponService.findById(itemId);
    }

    @PostMapping("/createcoupon")
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return couponService.createCoupon(coupon);

    }

    @PostMapping("/updatecoupon")
    public Coupon updateCoupon(@RequestBody Coupon coupon) {
        return couponService.updateCoupon(coupon);
    }

    @DeleteMapping("{id}")
    public boolean deleteCouponById(@PathVariable("id") int id) {
        return couponService.deleteCouponById(id);
    }

}
